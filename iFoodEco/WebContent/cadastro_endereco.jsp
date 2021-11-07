<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br"> 	
 	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
		<title>Ifood para Parceiros</title>  
        <link rel="stylesheet" href="styles/reset.css">      
        <link rel="stylesheet" href="styles/style.css">
		<link rel="icon" href="Imagem/logo_aba.png">
	</head>

	<body>
		<header>
			<div class="cabeçalho" >
				<h1 class="seta" ><img src="Imagem/seta2.png" alt="Voltar"></h1> 
				<h1 class="logo" style="display: block; margin-right: auto; margin-left: auto;" ><img src="Imagem/logo_ifood3.png" alt="Logo Ifood"></h1>        
			</div>            
			<div class="faixa"></div>
		</header>

		<main class="main_formato">
			<div class="principal">
				<h1 class="titulo-principal">Endereço da loja</h1>
				<h3 class="subtitulo" >Preencha as informações de endereço da sua loja.</h3>
			</div>

			<!--Importando Script Jquery-->
			<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

			<div class="formulario">
				<form action="secondStep" method="post">
					<label for="cep" style="font-size: 15px">CEP</label>
					<input name="cep" id="cep" type="text" required style="width: 500px; height: 40px; font-size: 17px" />
					<label for="uf"style="font-size: 15px; margin: 20px 0">Estado</label>
					<select name="estado" id="uf" style="width: 500px; height: 40px;font-size: 17px;" >
						<option value="AC">Acre</option>
						<option value="AL">Alagoas</option>
						<option value="AP">Amapá</option>
						<option value="AM">Amazonas</option>
						<option value="BA">Bahia</option>
						<option value="CE">Ceará</option>
						<option value="DF">Distrito Federal</option>
						<option value="ES">Espírito Santo</option>
						<option value="GO">Goiás</option>
						<option value="MA">Maranhão</option>
						<option value="MT">Mato Grosso</option>
						<option value="MS">Mato Grosso do Sul</option>
						<option value="MG">Minas Gerais</option>
						<option value="PA">Pará</option>
						<option value="PB">Paraíba</option>
						<option value="PR">Paraná</option>
						<option value="PE">Pernambuco</option>
						<option value="PI">Piauí</option>
						<option value="RJ">Rio de Janeiro</option>
						<option value="RN">Rio Grande do Norte</option>
						<option value="RS">Rio Grande do Sul</option>
						<option value="RO">Rondônia</option>
						<option value="RR">Roraima</option>
						<option value="SC">Santa Catarina</option>
						<option value="SP">São Paulo</option>
						<option value="SE">Sergipe</option>
						<option value="TO">Tocantins</option>
					</select>
					
					<label for="bairro"style="font-size: 15px; margin: 20px 0">Bairro</label>
					<input name="bairro" id="bairro" type="text" required style="width: 500px; height: 40px; font-size: 17px" />
					<label for="logradouro"style="font-size: 15px; margin: 20px 0">Endereço</label>
					<input name="logradouro" id="logradouro" type="text" required style="width: 500px; height: 40px; font-size: 17px";/>				
					
					<div class="alinhar" style="display: inline-flex;">
						<label for="numero"style="font-size: 15px; margin: 20px 0">Número</label>				
						<label for="complemento"style="font-size: 15px; margin: 20px 210px">Complemento</label>			
					</div>
					
					<div class="alinhar" style="display: inline-flex;">				
						<input name="numero" id="numero" type="text" style="width: 240px; height: 40px; font-size: 17px;" />				
						<input name="complemento" id="complemento" type="text" style=" width: 240px; height: 40px; font-size: 17px; margin-left: 15px"/>	
					</div>

					<input type="submit" value="Continuar" class="enviar">
				</form>
			</div>
			
			<script type="text/javascript">
				$("#cep").focusout(function(){
					//Início do Comando AJAX
					$.ajax({
						//O campo URL diz o caminho de onde virá os dados
						//É importante concatenar o valor digitado no CEP
						url: 'https://viacep.com.br/ws/'+$(this).val()+'/json/unicode/',
						//Aqui você deve preencher o tipo de dados que será lido,
						//no caso, estamos lendo JSON.
						dataType: 'json',
						//SUCESS é referente a função que será executada caso
						//ele consiga ler a fonte de dados com sucesso.
						//O parâmetro dentro da função se refere ao nome da variável
						//que você vai dar para ler esse objeto.
						success: function(resposta){
							//Agora basta definir os valores que você deseja preencher
							//automaticamente nos campos acima.
							$("#logradouro").val(resposta.logradouro);
							$("#complemento").val(resposta.complemento);
							$("#bairro").val(resposta.bairro);
							$("#cidade").val(resposta.localidade);
							$("#uf").val(resposta.uf);
							//Vamos incluir para que o Número seja focado automaticamente
							//melhorando a experiência do usuário
							$("#numero").focus();
						}
					});
				});
			</script>
		</main>
	</body>
</html>