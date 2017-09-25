<%@ page import="jhi.gobii.ui.*" %>
<%@ page import="jhi.gobii.ui.xml.*" %>

<%
Test test = new Test();
XmlLauncherList list = test.getLaunchers();
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    
    <title>GOBII Portal</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/font-awesome.min.css" rel="stylesheet">


    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script src="assets/js/modernizr.js"></script>
</head>

<body data-spy="scroll" data-target=".navbar" data-offset="50">

    <!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
                <a class="navbar-brand" href="http://gobiiproject.org/"><img src="assets/img/gobii.png" />
                </a>
                <!--<a class="navbar-brand" href="index.html"><img src="assets/img/icon.svg" />-->
                </a>
            </div>
            <div class="navbar-collapse collapse navbar-right">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#headerwrap">HOME</a>
                    </li>
                    <li><a href="#portfoliowrap">PORTAL</a>
                    </li>
                    <li><a href="#download">DOWNLOAD</a>
                    </li>
                    <li><a href="#developers">DEVELOPERS</a>
                    </li>
                    <li><a href="#funders">FUNDERS</a>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>

    <!-- *****************************************************************************************************************
	 HEADERWRAP
	 ***************************************************************************************************************** -->
    <div id="headerwrap">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <h1>Welcome to GOBII</h1>
                    <h3>The Genomic Open-source Breeding Informatics Initiative</h3>
                </div>
                <div class="col-lg-8 col-lg-offset-2 himg">
                    <!--<img src="assets/img/something.png" class="img-responsive">-->
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /headerwrap -->

    

    

    <!-- *****************************************************************************************************************
	 PORTFOLIO SECTION
	 ***************************************************************************************************************** -->
    <div id="portfoliowrap">
        <h3>GOBII Portal</h3>

        <div class="container text-left">
            <div class="row">
                <div class="col-xs-12">
                    <p>This portal allows you to access various components within the GOBII system.</p>
					<p>List count is <%= list.getList().size() %></p>
					<p>&nbsp;</p>
					<p>Colors require some work! This has been put together quickly using JSP/servlets rather than a full framework just to prove the concept.
					Configuration of the page is based off of a <a href="launchers.xml">simple XML file</a> that defines the links, logos, etc. This could be made web-enabled so no low-level
					editing is required at all. CSS/design is Bootstrap-based using a <a href="http://blacktie.co/demo/solid/">freely available theme</a>. A fully
					developed version would likely support internationalization (multi-languages) and customization of all elements, not just the links.</P>
					<p>&nbsp;</p>
                </div>
            </div>
        </div>



        <div class="container-fluid">
            <div class="row" id="portfolio">

<% for (int i = 0; i < list.getList().size(); i++) { %>
			
				<div class="col-xs-12 col-sm-6 col-md-4 col-lg-2 no-padding portfolio-item" >
                    <div class="portfolio-item graphic-design">
                        <div class="he-wrap tpl6 <%= list.getList().get(i).getColor() %>">
                            <img src="<%= list.getList().get(i).getLogo() %>" alt="">
                            <div class="instance-view">
                                <div class="bg a0">
                                    <h3 class="a1"><%= list.getList().get(i).getName() %></h3>
                                    <a href="<%= list.getList().get(i).getUrl() %>" class="dmbutton a2"><i class="fa fa-link"></i></a>
<% if (list.getList().get(i).getUrl2() != null) { %>
									<a href="<%= list.getList().get(i).getUrl2() %>" class="dmbutton a2" title="wibble"><i class="fa fa-rocket"></i></a>
<% } %>
									<p><%= list.getList().get(i).getDescription() %></p>
                                </div>
                                <!-- he bg -->
                            </div>
                            <!-- he view -->
                        </div>
                        <!-- he wrap -->
                    </div>
                    <!-- end col-12 -->
                </div>

<% } %>				
				

            </div>
        </div>
    </div>
    <!--/Portfoliowrap -->


    

    <!-- *****************************************************************************************************************
	 FOOTER
	 ***************************************************************************************************************** -->
    <div id="footerwrap">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <h4>About</h4>
                    <div class="hline-w"></div>
                    <p>
					GOBII is the first large-scale public-sector effort to systematically apply high-density genotypic information to the
					breeding of staple crops in the developing world. The project will develop and implement genomic data managment systems
					to enhance the capacity of public sector breeding programs to deliver increased rates of genetic gain. Initially the focus
					is on rice, wheat, maize, sorghum and chickpea in South Asia and Sub-Saharan Africa. The genomic data management systems
					will include databases, imputation systems, and decision support tools for plant breeders.
                    </p>
                </div>
                <div class="col-lg-4">
                    <h4>Useful Links</h4>
                    <div class="hline-w"></div>
                    <p>
                        <a href="https://twitter.com/GOBII_DB"><i class="fa fa-twitter"></i></a>
                        <a href="mailto:someone@somewhere.com"><i class="fa fa-envelope"></i></a>
                    </p>
                </div>
                <div class="col-lg-4">
                    <h4>Address</h4>
                    <div class="hline-w"></div>
                    <p>
                         Information &amp; Computational Sciences
                        <br/> The James Hutton Institute
                        <br/> Invergowrie
                        <br/> Dundee
                        <br/> DD2 5DA
                        <br/> Scotland
                    </p>
                </div>

            </div>
            <! --/row -->
        </div>
        <! --/container -->
    </div>
    <! --/footerwrap -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/retina-1.1.0.js"></script>
    <script src="assets/js/shuffle.min.js"></script>
    <script src="assets/js/jquery.parallax-1.1.3.js"></script>
    <script src="assets/js/custom.js"></script>
	
	

</body>

</html>
