var posX= Math.floor(Math.random() * (500 + 1));
var posY= Math.floor(Math.random() * (500 + 1));
$(document).ready(dibujar);

var posX = 350;
var posY = 250;
var x = 1;
var y = 1;
var movx = 1;
var movy = 1;


function dibujar(){	
	lienzo = $("#canvas")[0];	
    var contexto = lienzo.getContext("2d");
	if( posX >= lienzo.width-20 || posX <= 20 )
   		movx = movx*-1;
	if( posY >= lienzo.height-20 || posY <= 20 )
   		movy = movy*-1;
	posX = posX+(movx*x);
	posY = posY+(movy*y);
	contexto.beginPath();
	contexto.clearRect(0,0,lienzo.width,lienzo.height);
	contexto.fillStyle="rgb(255,0,0)";
	contexto.arc(posX, posY, 20, 0, 360,false);
	contexto.fill();
	setTimeout("dibujar()",0.5);
}


function procesarEvento(evento){
    //alert(evento.type + ": " + evento.which );
	if(evento.which==37){
 		//alert("Izquierda.");
 		if(x>1){
 			x--;
 		}
 	}else if(evento.which==38){
 		//alert("Arriba.");
 		y++;
 	}else if(evento.which==39){
 		//alert("Derecha.");
 		x++;
 	}else if(evento.which==40){
 		//alert("Abajo.");
 		if(y>1){
 			y--;
 		}
 	}
}
$(document).keydown(procesarEvento);
$(document).keypress(procesarEvento); 
$(document).keyup(procesarEvento);






