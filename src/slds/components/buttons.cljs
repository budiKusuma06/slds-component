(ns slds.components.buttons)

(defn button-template [{:keys [labl vart icon? post? img disabled?]}]
  [:button (merge 
            {:class (clojure.string/join " " ["slds-button"
                                                    (if vart (str "slds-button_" vart) "slds-button_neutral")])} 
            {:style 
             (merge 
              {:display "flex"} 
              {:justify-content "center"} 
              {:align-items "center"})} 
            (when disabled? 
                    {:disabled true}))
   (if icon?
     (cond
       (= post? :left)  [:span
                         [:svg
                          {:class "slds-button__icon slds-button__icon_left"
                           :aria-hidden true}
                          [:use
                           {:xlink-href
                            (str "/assets/icons/utility-sprite/svg/symbols.svg#" img)}]]
                         labl]
       (= post? :right) [:span
                         labl 
                         [:svg 
                          {:class "slds-button__icon slds-button__icon_right" 
                           :aria-hidden true} 
                          [:use 
                           {:xlink-href 
                            (str "/assets/icons/utility-sprite/svg/symbols.svg#" img)}]]]
       (nil? post?) [:span
                     [:svg
                      {:class "slds-button__icon"
                       :aria-hidden true}
                      [:use
                       {:xlink-href
                        (str "/assets/icons/utility-sprite/svg/symbols.svg#" img)}]]])
     (when-not 
      (nil? labl) labl))])

;; label
(defn label [labl disable]
  (button-template {:labl labl :icon? false :disabled? disable}))

(defn label-blot [labl disable]
  (button-template {:labl labl :vart "outline-brand" :icon? false :disabled? disable}))

(defn label-rd [labl disable]
  (button-template {:labl labl :vart "text-destructive" :icon? false :disabled? disable}))

(defn label-primary [labl disable]
  (button-template {:labl labl :vart "brand" :icon? false :disabled? disable}))

(defn label-danger [labl disable]
  (button-template {:labl labl :vart "destructive" :icon? false :disabled? disable}))

(defn label-success [labl disable]
  (button-template {:labl labl :vart "success" :icon? false :disabled? disable}))

;; icon
(defn icon [img disable]
  (button-template {:icon? true :img img :disabled? disable}))

(defn icon-blot [img disable]
  (button-template {:vart "outline-brand" :icon? true :img img :disabled? disable}))

(defn icon-rd [img disable]
  (button-template {:vart "text-destructive" :icon? true :img img :disabled? disable}))

(defn icon-primary [img disable]
  (button-template {:vart "brand" :icon? true :img img :disabled? disable}))

(defn icon-danger [img disable]
  (button-template {:vart "destructive" :icon? true :img img :disabled? disable}))

(defn icon-success [img disable]
  (button-template {:vart "success" :icon? true :img img :disabled? disable}))

;; left icon & label
(defn icon-lt [labl img disable]
  (button-template {:labl labl :icon? true :post? :left :img img :disabled? disable}))

(defn icon-lt-blot [labl img disable]
  (button-template {:labl labl :vart "outline-brand" :icon? true :post? :left :img img :disabled? disable}))

(defn icon-lt-rd [labl img disable]
  (button-template {:labl labl :vart "text-destructive" :icon? true :post? :left :img img :disabled? disable}))

(defn icon-lt-primary [labl img disable]
  (button-template {:labl labl :vart "brand" :icon? true :post? :left :img img :disabled? disable}))

(defn icon-lt-danger [labl img disable]
  (button-template {:labl labl :vart "destructive" :icon? true :post? :left :img img :disabled? disable}))

(defn icon-lt-success [labl img disable]
  (button-template {:labl labl :vart "success" :icon? true :post? :left :img img :disabled? disable}))

;; right icon & label
(defn icon-rt [labl img disable]
  (button-template {:labl labl :icon? true :post? :right :img img :disabled? disable}))

(defn icon-rt-blot [labl img disable]
  (button-template {:labl labl :vart "outline-brand" :icon? true :post? :right :img img :disabled? disable}))

(defn icon-rt-rd [labl img disable]
  (button-template {:labl labl :vart "text-destructive" :icon? true :post? :right :img img :disabled? disable}))

(defn icon-rt-primary [labl img disable]
  (button-template {:labl labl :vart "brand" :icon? true :post? :right :img img :disabled? disable}))

(defn icon-rt-danger [labl img disable]
  (button-template {:labl labl :vart "destructive" :icon? true :post? :right :img img :disabled? disable}))

(defn icon-rt-success [labl img disable]
  (button-template {:labl labl :vart "success" :icon? true :post? :right :img img :disabled? disable}))

;; button group
