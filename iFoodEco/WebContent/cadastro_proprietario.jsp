<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">
	 	
 	<head>
		<%@ include file="directiva.jsp" %>
  </head>

	<header>
		<div class="cabecalho" >
			<h1 class="seta"><a href="cadastro_endereco.jsp"><img src="Imagem/seta2.png" alt="Voltar"></a></h1>
			<h1 class="logo" style="display: block; margin-right: auto; margin-left: auto;" ><img src="Imagem/logo_ifood3.png" alt="Logo Ifood"></h1>       
		</div>           
		<div class="faixa"></div>
	</header>

	<body>
		<main class="main_formato">
			<div class="principal">
				<h1 class="titulo-principal">Informações da loja</h1>
				<h3 class="subtitulo" >Preencha abaixo as informações sobre a sua futura loja no Ifood.</h3>
			</div>			

			<div class="formulario">
				<form action="thirdStep" method="post">
					<label for="nome-loja" style="font-size: 15px">Nome da loja (como aparecerá no app)</label>
					<input name="nomeLoja" id="nome-loja" type="text" required style="width: 500px; height: 40px; font-size: 17px" />
					
					<label for="categoria"style="font-size: 15px; margin: 20px 0">Categoria</label>
					<select name="categoria" id="categoria" style="width: 500px; height: 40px;font-size: 17px;" >
						<option value="Açaí">Açaí</option>
						<option value="Africana">Africana</option>
						<option value="Alemã">Alemã</option>
						<option value="Árabe">Árabe</option>
						<option value="Argentina">Argentina</option>
						<option value="Bebidas">Bebidas</option>
						<option value="Brasileira">Brasileira</option>
						<option value="Cafeteria">Cafeteria</option>
						<option value="Carnes">Carnes</option>
						<option value="Casa de Sucos">Casa de Sucos</option>
						<option value="Chinesa">Chinesa</option>
						<option value="Colombiana">Colombiana</option>
						<option value="Congelados">Congelados</option>
						<option value="Conveniência">Conveniência</option>
						<option value="Coreana">Coreana</option>
						<option value="Doces e Bolos">Doces e Bolos</option>
						<option value="Espanhola">Espanhola</option>
						<option value="Francesa">Francesa</option>
						<option value="Frutos do Mar">Frutos do Mar</option>
						<option value="Indiana">Indiana</option>
						<option value="Italiana">Italiana</option>
						<option value="Japonesa">Japonesa</option>
						<option value="Lanches">Lanches</option>
						<option value="Marmita">Marmita</option>
						<option value="Mediterrânea">Mediterrânea</option>
						<option value="Mexicana">Mexicana</option>
						<option value="Padaria">Padaria</option>
						<option value="Pastel">Pastel</option>
						<option value="Peixes">Peixes</option>
						<option value="Peruana">Peruana</option>
						<option value="Pizza">Pizza</option>
						<option value="Portuguesa">Portuguesa</option>
						<option value="Salgados">Salgados</option>
						<option value="Saudável">Saudável</option>
						<option value="Sorvetes">Sorvetes</option>
						<option value="Tailandesa">Tailandesa</option>
						<option value="Vegetariana">Vegetariana</option>					
					</select>
					
					<label for="cnpj"style="font-size: 15px; margin: 20px 0">CNPJ</label>
					<input name="cnpj" id="cnpj" type="text" required style="width: 500px; height: 40px; font-size: 17px" />								


					<div class="principal">
						<h1 class="titulo-principal">Informações da Conta</h1>			
						<h3 class="subtitulo" >Preencha abaixo com as informações sobre sua conta bancária. </h3>
					</div>
					<div class="formulario">
						<label for="agencia" style="font-size: 15px">Número da agência</label>
						<input name="agencia" id="agencia" type="text" required style="width: 500px; height: 40px; font-size: 17px; margin: 20px 0;" />
						<label for="conta" style="font-size: 15px">Número da conta</label>
						<input name="conta" id="conta" type="text" required style="width: 500px; height: 40px; font-size: 17px; margin: 20px 0;" />
						<input type="submit" value="Continuar" class="enviar">
					</div>
				</form>
			</div>					
		</main>
  </body>
</html>