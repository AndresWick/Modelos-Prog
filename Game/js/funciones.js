$(document).ready(function(){
	$("#Jugar").click(function(){
		jugar();
		$('#Jugar').hide();
		$('#Pausa').show();
		$('#Reanudar').hide();
	});
	$('#Pausa').click(function(){
		clearInterval(game_loop);
		$('#Pausa').hide();	
		$('#Reanudar').show();
		$('#Salir').show();
	});
	$('#Reanudar').click(function(){
		clearInterval(game_loop);
		$('#Pausa').show();	
		$('#Reanudar').hide();
	game_loop = setInterval(dibujar, 60);
	});
	$("#Salir").click(function(){
		clearInterval(game_loop);
		$('#Jugar').show();	
		$('#Pausa').hide();
		$('#Reanudar').hide();
		$('#Salir').hide();
	
	});
});

var canvas = $("#canvas")[0];
var contexto = canvas.getContext("2d");
var w = $("#canvas").width();
var h = $("#canvas").height();
// Tamaño de los cuadros.
var tamCuadro = 10;
// Dirección de la serpiente.
var direccion;
var comida;
var puntaje;
// Variable que representa la serpiente.
var serpiente; 

function jugar(){
	// Dirección inicial por defecto.
	direccion = "right"; 
	crear_serpiente();
	crear_comida(); 
	puntaje = 0;
	if(typeof game_loop != "undefined") clearInterval(game_loop);
	game_loop = setInterval(dibujar, 60);
}
	
function crear_serpiente(){
	// Tamaño inicial por defecto.
	var tamaño = 3; 
	serpiente = []; 
	for(var i = tamaño-1; i>=0; i--){
		serpiente.push({x: i, y:0});
	}
}

function crear_comida(){
	comida = {
		x: Math.round(Math.random()*(w-tamCuadro)/tamCuadro), 
		y: Math.round(Math.random()*(h-tamCuadro)/tamCuadro), 
	};
}

function dibujar(){
/*	contexto.fillStyle = "hsla(244, 11%, 80%, 1)";
	contexto.fillRect(0, 0, w, h);
	contexto.strokeStyle = "white";
	contexto.strokeRect(0, 0, w, h);/*
/*
	for(var i=0;i<(canvas.height/10);i++){
		for (var j=0;j<(canvas.width/10); j++) {
			contexto.strokeRect(10*i, 10*j, 10, 10);
		};
	}
      */
 /*   $("#canvas").css({
    "position": "center",
    "border": "$line-color 1px solid",
    "box-shadow": "0px 0px 20px black",
    "width": "$width",
    "background-image": "-webkit-linear-gradient(45deg, black 25%, transparent 25%, transparent 75%, black 75%, black), -webkit-linear-gradient(45deg, black 25%, transparent 25%, transparent 75%, black 75%, black)",
	"background-image": "linear-gradient(45deg, black 25%, transparent 25%, transparent 75%, black 75%, black), linear-gradient(45deg, black 25%, transparent 25%, transparent 75%, black 75%, black)",
    "background-size":"20px 20px",
    "background-position":"0 0, 10px 10px"
    });
*/

	$("#canvas").css("background-image","-webkit-linear-gradient(45deg, black 25%, transparent 25%, transparent 75%, black 75%, black), -webkit-linear-gradient(45deg, black 25%, transparent 25%, transparent 75%, black 75%, black)");

	var posX = serpiente[0].x;
	var posY = serpiente[0].y;

	if(direccion == "right") posX++;
	else if(direccion == "left") posX--;
	else if(direccion == "up") posY--;
	else if(direccion == "down") posY++;
	
	if(posX == -1 || posX == w/tamCuadro || posY == -1 || posY == h/tamCuadro || colision(posX, posY, serpiente)){
		$('#songs2')[0].play();
		$('#Pausa').hide();
		$('#Reanudar').hide();
		$('#Jugar').show();
		clearInterval(game_loop);	
		return;
	}
	if(posX == comida.x && posY == comida.y){
		var tail = {x: posX, y: posY};
		$('#songs')[0].play();
		puntaje++;
		crear_comida();
	}else{
		var tail = serpiente.pop(); 
		tail.x = posX; tail.y = posY;
	}
	
	serpiente.unshift(tail); 
	
	for(var i = 0; i < serpiente.length; i++){
		var c = serpiente[i];
		dibujar_celda(c.x, c.y);
	}

	dibujar_celda(comida.x, comida.y);
	var puntaje_text = "Puntaje: " + puntaje;
	$("#puntaje").html(puntaje_text);
}
	
function dibujar_celda(x, y){
	contexto.fillStyle = "hsla(79, 100%, 50%, 1)";
	contexto.fillRect(x*tamCuadro, y*tamCuadro, tamCuadro, tamCuadro);
	contexto.strokeStyle = "hsla(187, 2%, 50%, 1)";
	contexto.strokeRect(x*tamCuadro, y*tamCuadro, tamCuadro, tamCuadro);
}
	
function colision(x, y, arreglo){
	for(var i = 0; i < arreglo.length; i++){
		if(arreglo[i].x == x && arreglo[i].y == y)
			return true;
	}
	return false;
}
	
$(document).keydown(function(e){
	var tecla = e.which;
	if((tecla == "37" || tecla == "65") && direccion != "right") direccion = "left";
	else if((tecla == "38" || tecla == "87") && direccion != "down") direccion = "up";
	else if((tecla == "39" || tecla == "68") && direccion != "left") direccion = "right";
	else if((tecla == "40" || tecla =="83") && direccion != "up") direccion = "down";
})
