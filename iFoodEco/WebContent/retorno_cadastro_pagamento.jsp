<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="restaurant" class="br.com.ifoodeco.entity.Restaurant" scope="request"/>
<!doctype html>
    <html lang="pt-br">     
    <head>
        <%@ include file="directiva.jsp" %>
    </head>    

	<header>
        <script>
            window.onload = function() {
                document.getElementById('fpLink').style.color = "#ea1d2c";
                document.getElementById('fpIcon').scr = "Imagem/9-vermelho.png";
            }
        </script>
    </header>

    <body>
        <%@ include file="menu.jsp" %>

        <div class="dados_cadastrados">
            <h1 class="titulo-principal-recadastro">Formas de pagamento cadastrados</h1>      
            <img class="editar" src="Imagem/editar.png" onClick="habilitar()"> 
        </div> 

        <main class="main_formato_recadastro">

            <fieldset>
                <div>                           
                    <label><input type="checkbox" name="pagamento1"style="margin: 10px 2px;">Ifood Online</label>
                </div>  
                <div>           
                    <label><input type="checkbox" name="pagamento2"style="margin: 10px 2px;">AMEX</label>   
                </div> 
                <div> 
                    <label><input type="checkbox" name="pagamento3"style="margin: 10px 2px;">Mastercard</label>
                </div>
                <div>
                    <label><input type="checkbox" name="pagamento4"style="margin: 10px 2px;">Elo</label>
                </div>
                <div>
                    <label><input type="checkbox" name="pagamento5"style="margin: 10px 2px;">Visa</label>
                </div>                      
                <div>               
                    <label><input type="checkbox" name="pagamento6"style="margin: 10px 2px;">PayPal</label>
                </div> 
                <div>
                    <label><input type="checkbox" name="pagamento7"style="margin: 10px 2px;">Vale alelo</label>
                </div>                      
            </fieldset>

            <h1 style="margin: 30px 0;">Chaves PIX Cadastrados Cadastradas</h1>
            <div>
                <label for="email-recadastro"style="font-size: 15px; margin: 20px 0">E-mail</label>
            </div> 
            <div style="display: inline-flex;">         
                <input id="email-recadastro" type="text" placeholder=" ***Não há e-mail cadastrado***" required style="width: 500px; height: 40px; font-size: 17px; margin: 0 0 30px;" />
            </div>
            <div>
                <label for="celular-recadastro"style="font-size: 15px; margin: 20px 0">Celular</label>           
            </div>
            <div style="display: inline-flex;">
                <input id="celular-recadastro" type="text" placeholder=" ***Não há celular cadastrado***" required style="width: 500px; height: 40px; font-size: 17px; margin: 0 0 30px;" /> 
            </div>                
            <div>
                <label for="cnpj-recadastro"style="font-size: 15px; margin: 20px 0">CNPJ</label>           
            </div>
            <div style="display: inline-flex;">
                <input id="cnpj-recadastro" type="text" placeholder=" ***Não há CNPJ cadastrado***" required style="width: 500px; height: 40px; font-size: 17px;" />
            </div>
             
            <script>
                function habilitar() {
                    if (document.getElementById('select-plano').disabled == true) 
                    {
                        document.getElementById('select-plano').disabled = false;
                        document.getElementById('select-categoria').disabled = false;
                        document.getElementById('nome-restaurante-selecao').disabled = false;
                        document.getElementById('telefone-selecao').disabled = false;
                        document.getElementById('email-selecao').disabled = false;
                		document.getElementById('logradouro-selecao').disabled = false;
                        document.getElementById('cep-selecao').disabled = false;
                        document.getElementById('nr-logradouro-selecao').disabled = false;
                        document.getElementById('complemento').disabled = false;
                        document.getElementById('inputAtualizar').hidden = false;
                    }else{
                        document.getElementById('select-plano').disabled = true;
                        document.getElementById('select-categoria').disabled = true;
                        document.getElementById('nome-restaurante-selecao').disabled = true;
                        document.getElementById('telefone-selecao').disabled = true;
                        document.getElementById('email-selecao').disabled = true;
                        document.getElementById('logradouro-selecao').disabled = true;
                        document.getElementById('cep-selecao').disabled = true;
                        document.getElementById('nr-logradouro-selecao').disabled = true;
                        document.getElementById('complemento').disabled = true;
                        document.getElementById('inputAtualizar').hidden = true;
                    }
                }
            </script>
        </main>
    </body>
</html>