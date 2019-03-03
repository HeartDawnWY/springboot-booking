<#macro header>
<head>
    <title>预约系统</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="author" content="ThemeStarz" />
    <link href='http://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css' />
    <link href="${ urls.getForLookupPath('/css/theme.css') }" rel="stylesheet" />
    <link href="${ urls.getForLookupPath('/css/bootstrap.css') }" rel="stylesheet" />
    <link href="${ urls.getForLookupPath('/plugins/wow/animate.css') }" rel="stylesheet" />
    <link href="${ urls.getForLookupPath('/plugins/slick-nav/slicknav.css') }" rel="stylesheet" />
    <link href="${ urls.getForLookupPath('/plugins/slick/slick.css') }" rel="stylesheet" />
    <link href="${ urls.getForLookupPath('/plugins/font-awesome/css/font-awesome.min.css') }" rel="stylesheet" />
</head>
</#macro>

<#macro menu>
<header id="site-header">
    <div id="site-header-top">
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <div class="clearfix">
                        <button class="btn btn-warning btn-lg header-btn visible-sm pull-right">List your Property for Free</button>
                        <p class="timing-in-header">Open Hours: Monday to Saturday - 8am to 6pm</p>
                    </div>
                </div>
                <div class="col-md-7">
                    <div class="clearfix">
                        <button class="btn btn-warning btn-lg header-btn hidden-sm">List your Property for Free</button>
                        <div class="language-in-header">
                            <i class="fa fa-globe"></i>
                            <label for="language-dropdown"> Language:</label>
                            <select name="currency" id="language-dropdown">
                                <option value="ENG">ENG</option>
                                <option value="AR">AR</option>
                                <option value="UR">UR</option>
                                <option value="NEO">NEO</option>
                                <option value="AKA">AKA</option>
                            </select>
                        </div>
                        <div class="currency-in-header">
                            <i class="fa fa-flag"></i>
                            <label for="currency-dropdown"> Currency: </label>
                            <select name="currency" id="currency-dropdown">
                                <option value="USD">USD</option>
                                <option value="EUR">EUR</option>
                                <option value="AOA">AOA</option>
                                <option value="XCD">XCD</option>
                                <option value="PKR">PKR</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <figure id="site-logo">
                    <a href="index.html"><img src="${urls.getForLookupPath('/images/logo.png')}" alt="Logo"></a>
                </figure>
            </div>
            <div class="col-md-6 col-sm-8">
                <nav id="site-nav" class="nav navbar-default">
                    <ul class="nav navbar-nav">
                        <li><a href="index.html">Home</a></li>
                        <li><a href="property-listing.html">Listing</a></li>
                        <li><a href="single-property.html">Property</a></li>
                        <li><a href="gallery.html">Gallery</a></li>
                        <li><a href="contact.html">contact</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-md-3 col-sm-4">
                <div class="contact-in-header clearfix">
                    <i class="fa fa-mobile"></i>
                    <span>
                    Call Us Now
                    <br>
                <strong>111 222 333 444</strong>
                </span>
                </div>
            </div>
        </div>
    </div>
</header>
</#macro>

<#macro hidden>
    <input type="hidden" id="domain" value="${domain}"/>
</#macro>