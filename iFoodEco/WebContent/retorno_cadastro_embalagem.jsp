<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="restaurant" class="br.com.ifoodeco.entity.Restaurant" scope="request"/>
<jsp:useBean id="" class="" scope="request"/>
<!doctype html>
<html lang="pt-br">     
    <head>
        <%@ include file="directiva.jsp" %>
    </head>    

	<header>
        <script>
            window.onload = function() {
                document.getElementById('embLink').style.color = "#ea1d2c";
                document.getElementById('embIcon').scr = "Imagem/12-vermelho.png";
            }
        </script>
    </header>

    <body>
        <%@ include file="menu.jsp" %>

        <div class="dados_cadastrados">
            <h1 class="titulo-principal-recadastro">Embalagens Cadastradas</h1>      
            <img class="editar" src="Imagem/editar.png" onClick="habilitar()"> 
        </div>

        <main class="main_formato_recadastro">
            <div>
                <label>
                    <input type="checkbox" name="pagamento1"style="margin: 10px 2px;">Embalagem de vidro
                </label>  
            </div>
            <div>
                <label>
                    <input type="checkbox" name="pagamento2" style="margin: 10px 2px;">Embalagem de aluminio
                </label> 
            </div>
            <div>
                <label>
                    <input type="checkbox" name="pagamento3"style="margin: 10px 2px;">Embalagem de isopor
                </label> 
            </div>
            <div>                        
                <label>
                    <input type="checkbox" name="pagamento4"style="margin: 10px 2px;">Embalagem de plástico
                </label>
            </div>
            <div>
                <label>
                    <input type="checkbox" name="pagamento4"style="margin: 10px 2px;">Embalagem de papel
                </label>
            </div>
            <div>
                <label>
                    <input type="checkbox" name="pagamento4"style="margin: 10px 2px;">Talher de plástico
                </label>
            </div>
            <div>
                <label>
                    <input type="checkbox" name="pagamento4"style="margin: 10px 2px;">Canudo de plástico
                </label>
            </div>
            <div>
                <label>
                    <input type="checkbox" name="pagamento5"style="margin: 10px 2px;">Outros
                </label>
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