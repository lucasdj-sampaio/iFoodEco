<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br"> 	
 	<head>
		<%@ include file="directiva.jsp" %>
  </head>

	<body>
        
		<header>
			<div class="cabecalho" >
				<h1 class="seta"><a href="embalagem.jsp"><img src="Imagem/seta2.png" alt="Voltar"></a></h1>
				<h1 class="logo" style="display: block; margin-right: auto; margin-left: auto;" ><img src="Imagem/logo_ifood3.png" alt="Logo Ifood"></h1>       
			</div>           
			<div class="faixa"></div>
		</header>

		<main class="main_formato">
			<div class="principal_planos" style="margin-left: 20px">
				<h1 class="titulo-principal">Selecione um plano</h1>			
			</div>

			<div class="planos">
				<div class="plano_basico">
					<a href="addRestaurant?plano=basico">
						<img src="Imagem/plano_basico.jpg">			
					</a> 	
				</div>

				<div class="plano_entrega">
					<a href="addRestaurant?plano=entrega">
						<img src="Imagem/plano_entrega.jpg">
					</a>
				</div>		
			</div>
    </main>
  </body>
</html>