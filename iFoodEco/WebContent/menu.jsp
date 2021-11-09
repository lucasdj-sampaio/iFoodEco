<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="faixa-indice">
  <div>
    <div class="logo"><img src="Imagem/logo_ifood3.png" alt="Logo Ifood"></img></div>
    <div class="user"><h2>${restaurant.name}</h2></div>
  </div>
 
  <div class="linkMenu2">
    <h1><img class="iconSize1" src="Imagem/1.png"></h1>             
    <a href="">Inicio</a>
  </div>

  <div class="linkMenu">
    <h1><img class="iconSize1" src="Imagem/2.png" id="perfilIcon"></h1> 
    <a href="getRestaurant?cnpj=${restaurant.cnpjNumber}&screen=1" id="perfilLink"> Perfil</a>
    <div class="novoFunc"><label>NOVO!</label></div>
  </div>

  <div class="linkMenu">
    <h1><img class="iconSize2" src="Imagem/12.png" id="embIcon"></h1> 
    <a href="getRestaurant?cnpj=${restaurant.cnpjNumber}&screen=2" id="embLink">Embalagens</a>
    <div class="novoFunc"><label>NOVO!</label></div>
  </div>
  
   <div class="linkMenu">
    <h1><img class="iconSize1" src="Imagem/9.png" id="fpIcon"></h1> 
    <a href="getRestaurant?cnpj=${restaurant.cnpjNumber}&screen=3" id="fpLink">Formas de pagamento</a>
  </div>

  <div class="linkMenu2" >
    <h1><img class="iconSize1" src="Imagem/3.png"></h1> 
    <a href="">Avaliações</a>
  </div>

  <div class="linkMenu2" >
    <h1><img class="iconSize2" src="Imagem/4.png"></h1> 
    <a href="">Pedidos</a>
  </div>

  <div class="linkMenu2" >
    <h1><img class="iconSize3" src="Imagem/5.png"></h1> 
    <a href="">Financeiro</a>
  </div>

  <div class="linkMenu2" >
    <h1><img class="iconSize2" src="Imagem/6.png"></h1> 
    <a href="">Cardápios</a>
  </div>

  <div class="linkMenu2" >
    <h1><img class="iconSize1" src="Imagem/7.png"></h1> 
    <a href="">Horários</a>
  </div>

  <div class="linkMenu2" >
    <h1><img class="iconSize4" src="Imagem/8.png"></h1> 
    <a href="">Areas de entrega</a>
  </div>

  <div class="linkMenu2" >
    <h1><img class="iconSize1" src="Imagem/10.png"></h1> 
    <a href="">Marketing</a>
  </div>

  <div class="linkMenu2" >
    <h1><img class="iconSize1" src="Imagem/11.png"></h1> 
    <a href="">Promoções</a>
  </div>
</div>