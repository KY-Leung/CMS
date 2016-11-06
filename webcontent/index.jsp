<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.6
Version: 4.5.6
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Dribbble: www.dribbble.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
Renew Support: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<%@ page import='com.control.EmailDispatcher'%>
<%@ page import='com.control.UserController'%>
<%! int new_case_id = -1 ; %>
<html lang="en">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->

    <head>
        <meta charset="utf-8" />
        <title>Fire</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
        <link href="./assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="./assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <link href="./assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="./assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="./assets/global/css/components-rounded.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="./assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <link href="./assets/layouts/layout2/css/layout.min.css" rel="stylesheet" type="text/css" />
        <link href="./assets/layouts/layout2/css/themes/blue.min.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="./assets/layouts/layout2/css/custom.min.css" rel="stylesheet" type="text/css" />
        <!-- BEGIN THEME LAYOUT STYLES -->
        <link href="./assets/layouts/layout2/css/google-map.css" rel="stylesheet" type="text/css" />
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="favicon.ico" /> </head>
        
        
        <% if (EmailDispatcher.email_dispatcher == null)
			(new EmailDispatcher()).dispatchInformation(); 
			if (request.getAttribute("new_case_id") != null) {
				new_case_id = (int) request.getAttribute("new_case_id"); 
			 %>
				<script>
				alert("Case <%= new_case_id %> is opened."); 
				</script>
			
			<% request.setAttribute("new_case_id", null); 
			} %>
		
    <!-- END HEAD -->

    <body class="page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid" onload="initMap()">
        <!-- BEGIN HEADER -->
        <div class="page-header navbar navbar-fixed-top">
            <!-- BEGIN HEADER INNER -->
            <div class="page-header-inner ">
                <!-- BEGIN LOGO -->
                <div class="page-logo">
                    <a href="index.jsp">
                        <img src="./assets/layouts/layout2/img/logo-default.png" alt="logo" class="logo-default" /> </a>
                    <div class="menu-toggler sidebar-toggler">
                        <!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
                    </div>
                </div>
                <!-- END LOGO -->
                <!-- BEGIN RESPONSIVE MENU TOGGLER -->
                <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"> </a>
                <!-- END RESPONSIVE MENU TOGGLER -->
                <!-- BEGIN PAGE TOP -->
                <div class="page-top">
                    <!-- BEGIN TOP NAVIGATION MENU -->
                    <div class="top-menu">
                        <ul class="nav navbar-nav pull-right">
                            <!-- BEGIN USER LOGIN DROPDOWN -->
                            <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                            <li class="dropdown dropdown-user">
                                <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                    <img alt="" class="img-circle" src="./assets/layouts/layout2/img/avatar3_small.jpg" />
                                    <span class="username username-hide-on-mobile"> Nick </span>
                                    <i class="fa fa-angle-down"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-menu-default">
                                    <li>
                                        <a href="login.jsp">
                                            <i class="icon-key"></i> Log Out </a>
                                    </li>
                                </ul>
                            </li>
                            <!-- END USER LOGIN DROPDOWN -->
                            <!-- BEGIN QUICK SIDEBAR TOGGLER -->
                            <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                            <li class="dropdown dropdown-extended quick-sidebar-toggler">
                                <span class="sr-only">Toggle Quick Sidebar</span>
                                <i class="icon-logout"></i>
                            </li>
                            <!-- END QUICK SIDEBAR TOGGLER -->
                        </ul>
                    </div>
                    <!-- END TOP NAVIGATION MENU -->
                </div>
                <!-- END PAGE TOP -->
            </div>
            <!-- END HEADER INNER -->
        </div>
        <!-- END HEADER -->
        <!-- BEGIN HEADER & CONTENT DIVIDER -->
        <div class="clearfix"> </div>
        <!-- END HEADER & CONTENT DIVIDER -->
        <!-- BEGIN CONTAINER -->
        <div class="page-container">
            <!-- BEGIN SIDEBAR -->
            <div class="page-sidebar-wrapper">
                <!-- END SIDEBAR -->
                <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
                <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
                <div class="page-sidebar navbar-collapse collapse">
                    <!-- BEGIN SIDEBAR MENU -->
                    <!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
                    <!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
                    <!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
                    <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
                    <!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
                    <!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
                    <ul class="page-sidebar-menu  page-header-fixed page-sidebar-menu-hover-submenu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
                        <li class="nav-item active open ">
                            <a href="javascript:;" class="nav-link nav-toggle">
                                <i class="icon-pointer"></i>
                                <span class="title">Maps</span>
                                <span class="selected"></span>
                                <span class="arrow open"></span>
                            </a>
                            <ul class="sub-menu">
                                <li class="nav-item  ">
                                    <a href="index.jsp" class="nav-link ">
                                        <span class="title">Fire</span>
                                        <span class="selected"></span>
                                    </a>
                                </li>
                                <li class="nav-item  ">
                                    <a class="nav-link ">
                                        <span class="title">Haze</span>
                                    </a>
                                </li>
                                <li class="nav-item  ">
                                    <a class="nav-link ">
                                        <span class="title">Bomb Shelter</span>
                                    </a>
                                </li>
                                <li class="nav-item  ">
                                    <a class="nav-link ">
                                        <span class="title">Free Masek</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <!--
                        <li class="nav-item  ">
                            <a href="javascript:;" class="nav-link nav-toggle">
                                <i class="icon-feed"></i>
                                <span class="title">Subscribe</span>
                                <span class="arrow"></span>
                            </a>
                        </li>
                        -->
                        <li class="nav-item operatorOnly">
                            <a href="javascript:;" class="nav-link nav-toggle">
                                <i class="icon-layers"></i>
                                <span class="title">Cases</span>
                                <span class="arrow"></span>
                            </a>
                            <ul class="sub-menu">
                                <li class="nav-item  ">
                                    <a href="cases_new.jsp" class="nav-link ">
                                        <span class="title">New</span>
                                    </a>
                                </li>
                                <li class="nav-item  ">
                                    <a href="cases_manage.jsp" class="nav-link ">
                                        <span class="title">Manage</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="nav-item operatorOnly">
                            <a href="javascript:;" class="nav-link nav-toggle">
                                <i class="icon-check"></i>
                                <span class="title">Useful Info</span>
                                <span class="selected"></span>
                                <span class="arrow open"></span>
                            </a>
                            <ul class="sub-menu">
                                <li class="nav-item  ">
                                    <a href="info_new.jsp" class="nav-link ">
                                        <span class="title">New</span>
                                        <span class="selected"></span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <!-- END SIDEBAR MENU -->
                </div>
                <!-- END SIDEBAR -->
            </div>
            <!-- END SIDEBAR -->
            <!-- BEGIN CONTENT -->
            <div class="page-content-wrapper">
                <!-- BEGIN CONTENT BODY -->
                <div class="page-content">
                    <input id="pac-input" class="controls" type="text" placeholder="Search Box">
                    <div id="map"></div>
                </div>
                <!-- END CONTENT BODY -->
            </div>
            <!-- END CONTENT -->
            <!-- BEGIN QUICK SIDEBAR -->
            <a href="javascript:;" class="page-quick-sidebar-toggler">
                <i class="icon-login"></i>
            </a>
            <div class="page-quick-sidebar-wrapper" data-close-on-body-click="false">
                <div class="page-quick-sidebar">
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a href="javascript:;" data-target="#quick_sidebar_tab_1" data-toggle="tab"> Settings</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active page-quick-sidebar-settings" id="quick_sidebar_tab_1">
                            <div class="page-quick-sidebar-settings-list">
                                <h3 class="list-heading">Notifications Subscription</h3>
                                <ul class="list-items borderless">
                                    <li> Fire
                                        <input type="checkbox" class="make-switch" data-size="small" data-on-color="success" data-on-text="ON" data-off-color="default" data-off-text="OFF"> </li>
                                    <li> Haze
                                        <input type="checkbox" class="make-switch" data-size="small" data-on-color="success" data-on-text="ON" data-off-color="default" data-off-text="OFF"> </li>
                                    <li> Bomb Shelter
                                        <input type="checkbox" class="make-switch" data-size="small" data-on-color="success" data-on-text="ON" data-off-color="default" data-off-text="OFF"> </li>
                                    <li> Free Mask
                                        <input type="checkbox" class="make-switch" data-size="small" data-on-color="success" data-on-text="ON" data-off-color="default" data-off-text="OFF"> </li>
                                </ul>
                                <h3 class="list-heading">Notifications Mode</h3>
                                <ul class="list-items borderless">
                                    <li> Web
                                        <input type="checkbox" class="make-switch" data-size="small" data-on-color="success" data-on-text="ON" data-off-color="default" data-off-text="OFF"> </li>
                                    <li> SMS
                                        <input type="checkbox" class="make-switch" data-size="small" data-on-color="success" data-on-text="ON" data-off-color="default" data-off-text="OFF"> </li>
                                    <li> Email
                                        <input type="checkbox" class="make-switch" data-size="small" data-on-color="success" data-on-text="ON" data-off-color="default" data-off-text="OFF"> </li>
                                </ul>
                                <div class="inner-content">
                                    <button class="btn btn-success" id="demo_1">
                                        <i class="icon-settings"></i> Save Changes</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END QUICK SIDEBAR -->
        </div>
        <% if (session.getAttribute("username") == null) { %>
			<script>
			var elements = document.getElementsByClassName("nav-item operatorOnly");
			for (var i = 0; i < elements.length; i++)
				elements[i].style.visibility = 'hidden'; 	
			// alert("we in first"); 
			</script>
		<% }
		%>
		
		<% if (session.getAttribute("username") != null) { 
			UserController user_controller = new UserController(); 
			if(user_controller.getUserType((String) session.getAttribute("username")) == UserController.PUBLIC_USER) {
				%>
				<script>
				
				// alert("we in second"); 
				var elements = document.getElementsByClassName("nav-item operatorOnly");
				for (var i = 0; i < elements.length; i++)
					elements[i].style.visibility = 'hidden'; 	
				</script>
			<% } } %>
		
		<% if (request.getAttribute("username") != null) {
			%>
			<script>
			alert("Welcome! <%= request.getAttribute("username") %> ."); 
			</script>
		
		<% request.setAttribute("username", null); } %>
        
        <!-- END CONTAINER -->
        <!--[if lt IE 9]>
<script src="./assets/global/plugins/respond.min.js"></script>
<script src="./assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
        <!-- BEGIN CORE PLUGINS -->
        <script src="./assets/global/plugins/jquery.min.js" type="text/javascript"></script>
        <script src="./assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="./assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
        <script src="./assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
        <script src="./assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="./assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="./assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
        <!-- END CORE PLUGINS -->
        <!-- BEGIN PAGE LEVEL PLUGINS (DIALOG)-->
        <script src="./assets/global/plugins/bootbox/bootbox.min.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="./assets/global/scripts/app.min.js" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN PAGE LEVEL SCRIPTS (DIALOG - Change content)-->
        <script src="./assets/pages/scripts/ui-bootbox.min.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <script src="./assets/layouts/layout2/scripts/layout.min.js" type="text/javascript"></script>
        <script src="./assets/layouts/layout2/scripts/demo.min.js" type="text/javascript"></script>
        <script src="./assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
        <!-- END THEME LAYOUT SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <script src="./assets/layouts/layout2/scripts/operator-access.js" type="text/javascript"></script>
        <script src="./assets/layouts/layout2/scripts/google-map.js" type="text/javascript"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAn2XDB3kPgcalI-ywGJIEbU1wZ4UNP0oQ&libraries=places"
         async defer></script>
    </body>

</html>