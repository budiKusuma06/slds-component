(ns slds.components.form
  (:require [reagent.core :as r]
            [re-frame.core :as re-frame]))

(defn checkbox [{:keys [labl required? error? disabled?]}]
  [:div {:class (clojure.string/join " " ["slds-form-element"
                                         (when error? "slds-has-error")])}
   [:div {:class "slds-form-element__control"}
    [:div {:class "slds-checkbox"}
     (when required?
       [:abbr {:class "slds-required" :title "required"} "*"])
     [:input {:type "checkbox" 
              :name "option" 
              :id labl 
              :value labl
              :checked true
              (when disabled? :disabled) (when disabled? true)
              (when error? :aria-describedby) (when error? (str labl "+error"))}]
     [:label {:class "slds-checkbox__label" :for labl}
      [:span {:class "slds-checkbox_faux"}]
      [:span {:class "slds-form-element__label"} labl]]]]
   (when error? 
     [:div {:class "slds-form-element__help" :id (str labl "+error")} "This field is required"])])

(defn checkbox-btn [{:keys [checked? on-checked]}]
  [:label {:class (clojure.string/join " " ["slds-checkbox-button"
                                            (when checked? "slds-checkbox-button_is-checked")])}
   [:input {:type "checkbox"
            :class "slds-assistive-text"
            :value "example-unique-id-37"
            :on-change on-checked
            :checked checked?}]
   [:span {:class "slds-icon_container slds-icon-utility-add slds-current-color"
           :title "Description of icon when needed"}
    [:svg {:class "slds-icon slds-icon_x-small"
           :aria-hidden true}
     [:use {:xlink-href (str "/assets/icons/utility-sprite/svg/symbols.svg#" (if checked? "check" "add"))}]]
    [:span {:class "slds-assistive-text"} "add product"]]])

