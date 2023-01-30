(ns slds.components.app-launcher)

(def app-list [{:scut "MC"
                :scol "red"
                :link "Marketing Cloud"
                :desc "Salesforce Marketing Cloud lets businesses of any size..."}
               {:scut "HR"
                :scol "blue"
                :link "HR Concierge"
                :desc "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsu"}
               {:scut "MM"
                :scol "green"
                :link "My Money"
                :desc "Manage your finances across multiple financial platforms..."}
               {:scut "MM2"
                :scol "gray"
                :link "My Money 2"
                :desc "Manage your finances across multiple financial platforms..."}] )

(defn app-launcher []
  [:section {:role "dialog" 
             :tabindex "-1" 
             :aria-modal true 
             :aria-labelledby "header43"
             :class "slds-modal slds-fade-in-open slds-modal_large slds-app-launcher"}
   [:div {:class "slds-modal__container"}
    ;; close button dialog
    [:button {:class "slds-button slds-button_icon slds-modal__close slds-button_icon-inverse"}
     [:svg {:class "slds-button__icon slds-button__icon_large"
            :aria-hidden true}
      [:use {:xlink-href "/assets/icons/utility-sprite/svg/symbols.svg#close"}]]]
    ;; header 
    [:div {:class "slds-modal__header slds-grid slds-grid_align-spread slds-grid_vertical-align-center"}
     [:h2 {:id "header43"
           :class "slds-text-heading_medium"}
      "App launcher"]
     [:div {:class "slds-app-launcher__header-search"}
      [:div {:class "slds-form-element"}
       [:label {:for "app-launcher-search"
                :class "slds-form-element__label slds-assistive-text"}
        "Find app"]
       [:div {:class "slds-form-element__control slds-input-has-icon slds-input-has-icon_left"}
        [:svg {:class "slds-input__icon"
               :aria-hidden true}
         [:use {:xlink-href "/assets/icons/utility-sprite/svg/symbols.svg#search"}]]
        [:input {:type "search"
                 :class "slds-input"
                 :id "app-launcher-search"
                 :placeholder "Find an app"}]]]]
     [:button {:class "slds-button slds-button_neutral"} "App exchange"]]
    
    [:div {:class "slds-modal__content slds-app-launcher__content slds-p-around_medium"
           :id "modal-content-id-1"}
     [:div {:class "slds-section slds-is-open"}
      [:h3 {:class "slds-section__title"}
       [:button {:arial-controls "appsContent"
                 :aria-expanded true
                 :class "slds-button slds-section__title-action"}
        [:svg {:class "slds-section__title-action-icon slds-button__icon slds-button__icon_left"
               :aria-hidden true}
         [:use {:xlink-href "/assets/icons/utility-sprite/svg/symbols.svg#switch"}]]
        [:span {:class "slds-truncate"
                :title "All apps"}
         "All apps"]]]
      [:div {:aria-hidden false
             :class "slds-section__content"
             :id "appsContent"}
       [:div {:class "slds-assistive-text"
              :id "drag-live-region"
              :aria-live "assertive"}
        "Sales cloud: final position 4 of 6"]
       ;; list apps
       [:ul {:class "slds-grid slds-grid_pull-padded slds-wrap"}
       ;;  cards
        (->> app-list
             (map (fn [{:keys [scut scol link desc]}]
                    [:li {:class "slds-p-horizontal_small slds-size_1-of-1 slds-medium-size_1-of-3"}
                     [:div {:draggable true
                            :class "slds-app-launcher__tile slds-text-link_reset slds-is-draggable"}
                      [:div {:class "slds-app-launcher__tile-figure"}
                       [:span {:class "slds-avatar slds-avatar_large"}
                        [:abbr {:class (str "slds-avatar__initials")
                                :title "Marketing cloud"
                                :style {:background-color scol}}
                         scut]]
                       [:div {:class "slds-m-top_xxx-small"}
                        [:button {:class "slds-button slds-button_icon"
                                  :aria-pressed false
                                  :title "reorder"}
                         #_[:svg {:class "slds-button__icon"
                                :aria-hidden true}
                          [:use {:xlink-href "/assets/icons/utility-sprite/svg/symbols.svg#rows"}]]
                         [:span {:class "slds-assistive-text"} "reorder"]]]]
                      [:div {:class "slds-app-launcher__tile-body"}
                       [:a {:href "#"} link]
                       [:p desc
                        [:button {:aria-describedby "help-0"
                                  :class "slds-button slds-button_reset slds-text-link"}
                         "More"]]
                       [:div {:class "slds-popover slds-popover_tooltip slds-nubbin_top-right slds-hide"
                              :role "tooltip"
                              :id "help-0"
                              :style {:position "absolute"
                                      :top "80px"
                                      :right "30px"}}
                        [:div {:class "slds-popover__body"}]]]]])))
        ]]]]]]) 