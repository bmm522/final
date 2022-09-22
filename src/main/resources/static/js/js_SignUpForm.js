/**
 * 
 */
        var x = document.getElementById("login");
            var y = document.getElementById("register");
            var z = document.getElementById("btn");
            
            
            function login(){
                x.style.left = "50px";
                y.style.left = "450px";
                z.style.left = "0";
                let size = document.getElementsByClassName('form-wrap');
                size[0].style.height = '480px';
                size[0].style.overflowY='hidden';
                
            }

            function register(){
                x.style.left = "-400px";
                y.style.left = "50px";
                z.style.left = "110px";
                let size = document.getElementsByClassName('form-wrap');
                size[0].style.height = '800px';
               size[0].style.overflowY='scroll';
               
            }