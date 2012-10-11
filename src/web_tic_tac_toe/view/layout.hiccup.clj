(doctype :html5)
[:html
 [:head
  [:meta {:http-equiv "Content-Type" :content "text/html" :charset "iso-8859-1"}]
  [:title "web-tic-tac-toe"]
  (include-js "/javascript/jquery-1.8.2.min.js")
  (include-css "/bootstrap/css/bootstrap.css")
  (include-css "/bootstrap/css/bootstrap-responsive.css")
  (include-css "/stylesheets/web_tic_tac_toe.css")
  (include-js "/bootstrap/js/bootstrap.min.js")]

 [:body
  [:div {:class "navbar navbar-fixed-top"}
   [:div {:class "navbar-inner"}
    [:div {:class "container"}
     [:a {:class "brand" :href "/"} "Tic-Tac-Toe"]
     [:div {:class "nav-collapse collapse"}
      [:ul {:class "nav"}
       [:li [:a {:href "game"} "Juego"]]]]]]]

  [:div {:class "container"}
   (eval (:template-body joodo.views/*view-context*))]
  ]]
