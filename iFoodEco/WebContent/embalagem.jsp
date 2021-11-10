<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">     
    <head>
        <%@ include file="directiva.jsp" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </head>
    
    <body>

        <header>
            <div class="cabecalho" >
                <h1 class="seta"><a href="pagamento.jsp"><img src="Imagem/seta2.png" alt="Voltar"></a></h1>
                <h1 class="logo" style="display: block; margin-right: auto; margin-left: auto;" ><img src="Imagem/logo_ifood3.png" alt="Logo Ifood"></h1>       
            </div>           
            <div class="faixa"></div>
        </header>
        
        <main class="main_formato">
            <div class="principal_pagamento">
                <h1 class="titulo-principal">Embalagens</h1>
                <h3 class="subtitulo" >Selecione abaixo as embalagens disponíveis em seu negócio.</h3>
            </div>  

            <script>
                function habilitacao(){
                  if(document.getElementById('outros').checked == true){
                    document.getElementById('embalagem-ex').disabled = false;
                    document.getElementById('add-campo').disabled = false;
                  }
                  if(document.getElementById('outros').checked == false){
                    document.getElementById('embalagem-ex').disabled = true;
                    document.getElementById('add-campo').disabled = true;
                  }
                }
            </script>

            <div class="container" style="display: flex;">
                <form action="fifthStep" method="post">
                    <div class="container-1" style="width: 500px;">
                        <div>
                            <label><input type="checkbox" name="embalagem" value="Embalagem de Vidro" style="margin: 10px 2px;">Embalagem de Vidro</label>  
                        </div>
                        <div>
                            <label><input type="checkbox" name="embalagem" value="Embalagem de Aluminio" style="margin: 10px 2px;">Embalagem de Aluminio</label> 
                        </div>
                        <div>
                            <label><input type="checkbox" name="embalagem" value="Embalagem de Isopor" style="margin: 10px 2px;">Embalagem de Isopor</label> 
                        </div>
                        <div>                        
                            <label><input type="checkbox" name="embalagem" value="Embalagem de Plastico" style="margin: 10px 2px;">Embalagem de Plastico</label>
                        </div>
                        <div>
                            <label><input type="checkbox" name="embalagem" value="Embalagem de Papel" style="margin: 10px 2px;">Embalagem de Papel</label>
                        </div>
                        <div>
                            <label><input type="checkbox" name="embalagem" value="Talheres de Plastico" style="margin: 10px 2px;">Talheres de Plastico</label>
                        </div>
                        <div>
                            <label><input type="checkbox" name="embalagem" value="Canudo de Plastico" style="margin: 10px 2px;">Canudo de Plastico</label>
                        </div>
                        <div>
                            <label><input type="checkbox" name="embalagem" value="Outros (Embalagem Ecológica)" style="margin: 10px 2px;">Outros (Embalagem Ecológica)</label>
                        </div>                     

                        <input type="submit" value="Continuar" class="enviar">                    
                    </div>          
                </form>      
            </div> 
        </main>
    </body>
</html>