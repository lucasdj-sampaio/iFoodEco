<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br"> 	
 	<head>
        <title>Ifood para Parceiros</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <link rel="stylesheet" href="styles/reset.css">      
        <link rel="stylesheet" href="styles/style.css">
        <link rel="icon" href="Imagem/logo_aba.png">
    </head>
    <body>
        <header>
        	<div class="cabeçalho" >
            <h1 class="seta" href="index.html"><a href="cadastro_endereço.html"><img src="Imagem/seta2.png" alt="Voltar"></a></h1> 
            <h1 class="logo" style="display: block; margin-right: auto; margin-left: auto;" ><img src="Imagem/logo_ifood3.png" alt="Logo Ifood"></h1>        
            </div>            
            <div class="faixa"></div>
        </header>

        <main class="main_formato">
        	<div class="principal">
					<h1 class="titulo-principal">Informações da loja</h1>
					<h3 class="subtitulo" >Preencha abaixo as informações sobre a sua futura loja no Ifood.</h3>
			</div>			

			<div class="formulario">
			<form>
				<label for="nome-loja" style="font-size: 15px">Nome da loja (como aparecerá no app)</label>
				<input id="nome-loja" type="text" required style="width: 500px; height: 40px; font-size: 17px" />
				<label for="categoria"style="font-size: 15px; margin: 20px 0">Categoria</label>
				<select id="categoria" style="width: 500px; height: 40px;font-size: 17px;" >
					<option value="açai">Açaí</option>
					<option value="africana">Africana</option>
					<option value="alema">Alemã</option>
					<option value="arabe">Árabe</option>
					<option value="argentina">Argentina</option>
					<option value="bebidas">Bebidas</option>
					<option value="brasileira">Brasileira</option>
					<option value="cafeteria">Cafeteria</option>
					<option value="carnes">Carnes</option>
					<option value="casa_de_sucos">Casa de Sucos</option>
					<option value="chinesa">Chinesa</option>
					<option value="colombiana">Colombiana</option>
					<option value="congelados">Congelados</option>
					<option value="conveniencia">Conveniência</option>
					<option value="coreana">Coreana</option>
					<option value="doces_bolos">Doces e Bolos</option>
					<option value="espanhola">Espanhola</option>
					<option value="francesa">Francesa</option>
					<option value="frutos_do_mar">Frutos do Mar</option>
					<option value="indiana">Indiana</option>
					<option value="italiana">Italiana</option>
					<option value="japonesa">Japonesa</option>
					<option value="lanches">Lanches</option>
					<option value="marmita">Marmita</option>
					<option value="mediterranea">Mediterrânea</option>
					<option value="mexicana">Mexicana</option>
					<option value="padaria">Padaria</option>
					<option value="pastel">Pastel</option>
					<option value="peixes">Peixes</option>
					<option value="peruana">Peruana</option>
					<option value="pizza">Pizza</option>
					<option value="portuguesa">Portuguesa</option>
					<option value="salgados">Salgados</option>
					<option value="saudavel">Saudável</option>
					<option value="sorvetes">Sorvetes</option>
					<option value="tailandesa">Tailandesa</option>
					<option value="vegetariana">Vegetariana</option>					
				</select>
				<label for="cnpj"style="font-size: 15px; margin: 20px 0">CNPJ</label>
				<input id="cnpj" type="text" required style="width: 500px; height: 40px; font-size: 17px" />							
				
			</form>
			</div>
			<div class="principal">
					<h1 class="titulo-principal">Informações da Conta</h1>			
					<h3 class="subtitulo" >Preencha abaixo com as informações sobre sua conta bancária. </h3>
					</div>
					<div class="formulario">
					<label for="agencia" style="font-size: 15px">Número da agência</label>
					<input id="agencia" type="text" required style="width: 500px; height: 40px; font-size: 17px; margin: 20px 0;" />
					<label for="conta" style="font-size: 15px">Número da conta</label>
					<input id="conta" type="text" required style="width: 500px; height: 40px; font-size: 17px; margin: 20px 0;" />
					<input type="submit" value="Continuar" class="enviar">
			
			</div>					
        </main>
    </body>
</html>