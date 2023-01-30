(ns slds.views
  (:require
   [re-frame.core :as re-frame]
   [slds.events :as events]
   [slds.routes :as routes]
   [slds.subs :as subs]
   [reagent.core :as r]
   [slds.components.buttons :as btn]
   [slds.components.form :as form]
   [slds.components.app-launcher :as app]
   ))

(def variant "neutral")

;; home

(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])
        form (r/atom {:is-customizable? false
                      :is-cheap? false})]
    (fn []
      [:div {:style {:margin "10px 50px"}}
       [:h1
        (str "Hello from " @name ". This is the Home Page.")]

    ;;  [:div
    ;;   (btn/label-success"post" false)]
       
    ;;  [:div
    ;;   (btn/icon-success "add" false)] 
       
    ;;  [:div
    ;;   (btn/icon-rt-success "add" "add" false)]
       [:div
        [form/checkbox {:labl "cek" 
                        :required? true 
                        :error? false}]]

       [:div
        [form/checkbox-btn {:checked? (:is-cheap? @form)
                            :on-checked #(let [prev-state (:is-cheap? @form)]
                                           (reset! form (assoc @form :is-cheap? (not prev-state))))}]] 
       [:div "is cheap?" [:label (str (:is-cheap? @form))]]
       
       [app/app-launcher]
       ])))

(defmethod routes/panels :home-panel [] [home-panel])

;; about

(defn about-panel []
  [:div
   [:h1 "This is the About Page."]

   [:div
    [:a {:on-click #(re-frame/dispatch [::events/navigate :home])}
     "go to Home Page"]]])

(defmethod routes/panels :about-panel [] [about-panel])

;; main

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    (routes/panels @active-panel)))
