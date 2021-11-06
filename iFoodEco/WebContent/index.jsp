<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br"> 	
 	<head>
        <title>Ifood para Parceiros</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <link rel="stylesheet" href="CSS/reset.css">      
        <link rel="stylesheet" href="CSS/style.css">
        <link rel="icon" href="Imagem/logo_aba.png">
    </head>

    <header class="faixa-dois" style="background-color: #ffffff">
        <div class="caixa"style="display: inline-flex; ">        	
        <h1 class="logo_index" ><img src="Imagem/logo_ifood_maior.png" alt="Logo Ifood"></h1>                    
        </div>            
    </header>

    <body class="background">
        <main class="cadastro">
        	<div class="principal_cadastro">
                <h1 class="titulo-principal-cadastro">Cadastre sua loja</h1>
                <h3 class="subtitulo-cadastro" >Entre e ganhe 1 mês de mensalidade grátis!</h3>
			</div>		

			<form name="first" action="firstStep" method="post">
				<label for="nomeesobrenome" style="font-weight: bold; font-size: 18px;">Nome Completo</label>
                
                <input type="text" name="nome" id="nomeesobrenome" class="input-padrao" required placeholder="João da Silva">
				
                <label for="email"style="font-weight: bold; font-size: 18px;">E-mail</label>
                
                <input type="email" name="email" id="email"class="input-padrao"required placeholder="email@email.com">	
            
                <label for="telefone" style="font-weight: bold; font-size: 18px">Telefone</label>

                <input type="tel" name="telefone" id="telefone" class="input-padrao" required placeholder ="(00) 00000-0000">

                <input type="submit" value="Cadastrar agora" class="cadastrar-agora" style="margin: 50px 18px;">
            </form>		
        </main>
    </body>
</html>