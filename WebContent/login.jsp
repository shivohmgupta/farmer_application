<%@page import="java.util.*"
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Login and Registration Form </title>
		<link rel="stylesheet" type="text/css" href="login.css" />
		
    </head>
    <body>
        <div class="container">
           
            <header>
                <h1>                        </h1>
                <h1>                        </h1>
                <h1>                        </h1>
                <h1>                        </h1>
				
            </header>
            <section>			
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                        <h1>Log in</h1>
                            <form  action="login_servlet" autocomplete="on" method="post"> 
                                
                                         <div  > 
                                         
									<input type="radio" name="choice"  value="farmer" style="width:50px;"/>  Log In As Farmer 
									   
									<input type="radio" name="choice"  value="customer" style="width:100px;" /> Log In As Customer
								
								</div>
								<br/><br/>
                                <p> 
                                    <label for="mobile_number" class="uname" >Your Registered Mobile Number </label>
                                    <input id="mobile" name="mobile" required="required" type="text" placeholder="mobile_number = xxxxxxxxxx"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd"> Your password </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                                </p>
                                
                                
                                
                                <p class="login button"> 
                                   <input type="submit" name="login" value="login">
								</p>
                                
                            </form>
                            <p class="change_link">
									Not a member yet ?
									<a href="#toregister" class="to_register">Join us</a>
								</p>
                        </div>
								
                        <div id="register" class="animate form">
                            <form  action="register_servlet" > 
                                <h1> Sign up </h1>  
                                
                                <div  > 
                                         
									<input type="radio" name="choice"  value="farmer" style="width:50px;"/>  Register As Farmer 
									   
									<input type="radio" name="choice"  value="customer" style="width:100px;" /> Register As Customer
								
								</div>
								<br/><br/>
                                                              
                                <p> 
                                    <label >First Name</label>
                                    <input id="firstname" name="firstname" required="required" type="text" placeholder="_____________" />
                                </p>
                                <p> 
                                    <label for="lastname" class="lastname"  > Last Name</label>
                                    <input id="lastname" name="lastname" required="required" type="text" placeholder="_______________"/> 
                                </p>
                                <p> 
                                    <label for="mobile" class="mobile" >Mobile Number</label>
                                    <input id="mobile" name="mobile" required="required" type="text" placeholder="________________" />
                                </p>
                                <p> 
                                    <label for="city" class="city" >City</label>
                                    <input id="city" name="city" required="required" type="text" placeholder="_________________" />
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" >Your password </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="eg. xxxxxxxxxx"/>
                                </p>
                                <p> 
                                    <label for="password_confirm" class="youpasswd" >Please confirm your password </label>
                                    <input id="password_confirm" name="password_confirm" required="required" type="password" placeholder="eg. xxxxxxxxxx"/>
                                </p>
                                
                                <p class="signin button"> 
                                
									<input type="submit" value="Sign up" name="Sign up"/> 
								</p>
                                <p class="change_link">  
									Already a member ?
									<a href="#tologin" class="to_register"> Go and log in </a>
								</p>
                            </form>
                        </div>
						
                    </div>
                </div>  
                
            </section>
        </div>
    </body>
</html>