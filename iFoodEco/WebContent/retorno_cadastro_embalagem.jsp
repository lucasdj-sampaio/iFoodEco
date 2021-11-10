<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="restaurant" class="br.com.ifoodeco.entity.Restaurant" scope="request"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="br.com.ifoodeco.entity.Restaurant"%>
<%@page import="br.com.ifoodeco.entity.Packaging"%>
<%@page import="java.util.List"%>

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

        <script>
            function habilitar() {
                var elements = document.getElementsByClassName('embalagemCheck');

                if (elements[0].disabled == true) {
                    document.getElementById('inputAtualizar').hidden = false;

                    for (var i = 0; i < elements.length; i++) {
                        elements[i].disabled = false;
                    }​                       
                }else{
                    document.getElementById('inputAtualizar').hidden = true;

                    for (var i = 0; i < elements.length; i++) {
                        elements[i].disabled = true;
                    }                        
                }
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
            <form action="updateProfile" method="post">   

                <c:forEach var="emb" items="${embList}">
                    <c:set var="exist" value="off"/>

                    <c:forEach var="restEmb" items="${restaurant.packList}">
                        <c:if test = "${emb.packagingName == restEmb.packagingName}">
                            <c:set var="exist" value="on"/>
                        </c:if>     
                    </c:forEach>
                    
                    <div>                   		
                        <label>
                            <c:choose>
                                <c:when test = "${exist == 'on'}">
                                    <input class="embalagemCheck" type="checkbox" name="embalagem" value=${emb.id} checked disabled>${emb.packagingName}
                                </c:when>
                                <c:otherwise>
                                    <input class="embalagemCheck" type="checkbox" name="embalagem" value=${emb.id} disabled=true>${emb.packagingName}
                                </c:otherwise>
                            </c:choose>
                        </label>
                    </div>
                </c:forEach> 

                <input type="submit" id="inputAtualizar" value="Atualizar Registros" class="enviar" hidden=true> 
            </form>
        </main>
    </body>
</html>