<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">     
    <head>
        <title>Ifood para Parceiros</title>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <link rel="stylesheet" href="styles/reset.css">      
        <link rel="stylesheet" href="styles/style.css">
        <link rel="icon" href="Imagem/logo_aba.png">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </head>
    <body>

        <%@ include file="directiva.jsp" %>
        
        <main class="main_formato">

            <div class="principal_pagamento">
                    <h1 class="titulo-principal">Embalagens</h1>
                    <h3 class="subtitulo" >Selecione abaixo as embalagens disponíveis em seu negócio.</h3>
            </div>  
            <script language="javascript">
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
                <div class="container-1" style="width: 500px;">
                        <div>
                            <label><input type="radio" name="pagamento1"style="margin: 10px 2px;">Embalagem de vidro</label>  
                        </div>
                        <div>
                            <label><input type="radio" name="pagamento2" style="margin: 10px 2px;">Embalagem de aluminio</label> 
                        </div>
                        <div>
                            <label><input type="radio" name="pagamento3"style="margin: 10px 2px;">Embalagem de isopor</label> 
                        </div>
                        <div>                        
                            <label><input type="radio" name="pagamento4"style="margin: 10px 2px;">Embalagem de plástico</label>
                        </div>
                        <div>
                            <label><input type="radio" name="pagamento4"style="margin: 10px 2px;">Embalagem de papel</label>
                        </div>
                        <div>
                            <label><input type="radio" name="pagamento4"style="margin: 10px 2px;">Talher de plástico</label>
                        </div>
                        <div>
                            <label><input type="radio" name="pagamento4"style="margin: 10px 2px;">Canudo de plástico</label>
                        </div>
                        <div>
                            <label><input type="radio" name="pagamento5"style="margin: 10px 2px;">Outros</label>
                        <div>                     

                        <input type="submit" value="CADASTRAR" class="enviar">                    
                 </div>                
            </div> 
        </main>
    </body>
</html>