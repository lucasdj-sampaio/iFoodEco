<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="restaurant" class="br.com.ifoodeco.entity.Restaurant" scope="request"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="br.com.ifoodeco.entity.Restaurant"%>
<%@page import="br.com.ifoodeco.entity.Category"%>
<%@page import="br.com.ifoodeco.entity.Plan"%>

<!doctype html>
    <html lang="pt-br">     
    <head>
        <%@ include file="directiva.jsp" %>
    </head>

    <header>
        <script>
            window.onload = function() {
                document.getElementById('perfilLink').style.color = "#ea1d2c";
                document.getElementById('perfilIcon').scr = "Imagem/2-vermelho.png";
            }
        </script>

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
    </header>

    <body>

        <%@ include file="menu.jsp" %>

        <div class="dados_cadastrados">
            <h1 class="titulo-principal-recadastro">Perfil cadastrado</h1>      
            <img class="editar" src="Imagem/editar.png" onClick="habilitar()"> 
        </div> 

        <main class="main_formato_recadastro">  
            <form action="updateProfile" method="post">               
                <div>
                    <label for="cnpj"style="font-size: 15px; ">CNPJ</label>
                    <input class="updateInput" value="${restaurant.cnpjNumber}" id="cnpj-selecao" type="text" disabled/> 
                    <input name="cnpj" class="updateInput" value="${restaurant.cnpjNumber}" id="cnpj-selecao" type="text" hidden/> 
                </div>
                
                <div>
                    <label for="categoria"style="font-size: 15px;">Plano Selecionado</label>
                    <select name="plano" id="select-plano" class="updateInput" required disabled>
                        <c:forEach var="currentPlan" items="${planList}">
                            <c:choose>
                                <c:when test = "${currentPlan.plan == restaurant.plan.plan}">
                                    <option value=${currentPlan.id} selected=>${currentPlan.plan}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value=${currentPlan.id}>${currentPlan.plan}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>                
                </div>
                
                <div>
                    <label for="categoria"style="font-size: 15px;">Categora Selecionada</label>
                    <select name="categoria" id="select-categoria" class="updateInput" required disabled>
                        <c:forEach var="currentCategory" items="${categoryList}">
                            <c:choose>
                                <c:when test = "${currentCategory.category == restaurant.category.category}">
                                    <option value=${currentCategory.id} selected=>${currentCategory.category}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value=${currentCategory.id}>${currentCategory.category}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select> 
                </div>
                
                <div>
                    <label for="nome-restaurante"style="font-size: 15px; margin: 20px 0">Nome do restaurante</label>
                    <input name="nomeLoja" class="updateInput" value="${restaurant.name}" id="nome-restaurante-selecao" type="text" required disabled />
                </div>
                
                <div>
                    <label for="telefone"style="font-size: 15px; margin: 20px 0">Número de telefone</label>
                    <input name="telefone" class="updateInput" value="${restaurant.number}" id="telefone-selecao" type="text" required disabled />
                </div>
                
                <div>
                    <label for="email"style="font-size: 15px; margin: 20px 0">E-mail</label>
                    <input name="email" value="${restaurant.emailAddress}" class="updateInput" id="email-selecao" type="text" required disabled />
                </div>
                
                <div>
                    <label for="logradouro"style="font-size: 15px; margin: 20px 0">Logradouro</label>
                    <input name="logradouro" value="${restaurant.address.street}" class="updateInput" id="logradouro-selecao" type="text" required disabled />
                </div>
                
                <div>
                    <label for="cep"style="font-size: 15px; margin: 20px 0">CEP</label>
                    <input name="cep" value="${restaurant.address.cep}" class="updateInput" id="cep-selecao" type="text" required disabled />
                </div>
                
                <div>
                    <label for="nr-logradouro"style="font-size: 15px; margin: 20px 0">Número do logradouro</label>
                    <input name="numero" value="${restaurant.address.number}" class="updateInput" id="nr-logradouro-selecao" type="text" required disabled /> 
                </div>
                
                <div>
                    <label for="complemento"style="font-size: 15px; margin: 20px 0">Complemento</label>
                    <input name="complemento" value="${restaurant.address.complement}" class="updateInput" id="complemento" type="text" disabled /> 
                </div>
                
                <input type="submit" id="inputAtualizar" value="Atualizar Registros" class="enviar" hidden=true> 
            </form>
        </main>
    </body>
</html>