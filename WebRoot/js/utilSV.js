var CADENA_ALFANUMERICO = 'ABCDEFGHIJKLMN\u00D1OPQRSTUVWXYZabcdefghijklmn\u00f1opqrstuvwxyz\u00E1\u00E9\u00ED\u00F3\u00FA-_1234567890. '
//Funcion de fecha
$(function () {
  $('[data-toggle="tooltip"]').tooltip()



  $(':input').each( function(){
    if ($(this).data("tipo") == "fecha")
    $(this).datetimepicker({
      format: 'yyyy-mm-dd'
    });
  });
});




$(document).ready(function() {
    $('table[name="tabla"]').DataTable( {
      "scrollY":        "250px", //Tamaño del cuerpo donde muestra el ecroll
      "scrollCollapse": true,
      "paging":         false,
      "select":         true,
      "info":           false
    });

    $("input[data-checkbox1]").checkboxpicker();

    //Valida si la estructura del texto es valida para correo
    $("input[type=email]").blur(function() {
      if (this.value != "") {
        emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
        if (emailRegex.test(this.value)) {
          styleCorrecto(this);
        } else {
          styleError(this);
        }
      }
    });

    $( "button[data-sig]" ).each(function () {
      if ($(this).data("sig") != undefined){
        var tabClick = $(this).data("sig");
        $(this).click(function(element, event){
          if ($('a[href="#'+tabClick+'"]').hasClass("disabled")){
            $('a[href="#'+tabClick+'"]').removeClass("disabled");
          }
          $('a[href="#'+tabClick+'"]').trigger("click");
          bloqueoAutomaticoTab();
        });
      }
    });


    //Para objetos vacios
    $( "input[data-isnull]" ).each(function () {
        $( "input[data-isnull]" ).blur(function (event) {
          if ($(this).val() == ""){
            styleError(this);
          } else {
            styleCorrecto(this);
          }
      });
    });

    //Bloquea pestalas de nav
    bloqueoAutomaticoTab();

    //Funcionalidad CheckBox en listado
    chechboxAll();

    $( ":input" ).blur(function (event) {
        var tipo = $(this).data("tipo");
        if (tipo == "moneda" || tipo == "numerico")
            $(this).val(formateCantidad($(this).val(), tipo));
    });

    //Switch para validar los campos basicos de acuerdo al tipo declarado
    //Solo cuando se este escribiendo
    $( ":input" ).keypress(function (event) {
      var key = event.charCode;
      switch ($(this).data("tipo")) {
        case "numero" :
          if (!(key >= 48 && key <= 57)){
            event.preventDefault();
          }
        break;
        case "texto":
          var keychar = String.fromCharCode(key);
          if (CADENA_ALFANUMERICO.indexOf(keychar) == -1){
            event.preventDefault();
          }
        break;
        case "numerico":
        //Pendiente
          if (!(key >= 48 && key <= 57)){
            event.preventDefault();
          }
        break;
        case "moneda":
        //Pendiente
          if (!(key >= 48 && key <= 57)){
            event.preventDefault();
          }
        break;
        case "telefono":
          if (!(key >= 48 && key <= 57)){
            event.preventDefault();
          }
        break;
      }
    });
});


/*
 * Funcion utilizada para recorrer los links de las pestañas
 * y bloquearlos si tienen el atributo "data-bloqueo"
 */
function bloqueoAutomaticoTab(){
  $( "a[data-bloqueo]" ).each(function () {
      $(this).addClass("disabled");
  });
}

/* Funcion temporal */
function bloqueoTab(el){
  $( ".nav-link" ).each(function () {
      $(this).addClass("disabled");
  });
  el.style.display="none";
  $("#btnDesbloqueo").css("display","block")
}

/* Funcion Temporal */
function desbloqueoTab(el){
  $( ".nav-link" ).each(function () {
      $(this).removeClass("disabled");
  });
  el.style.display="none";
  $("#btnBloqueo").css("display","block")
}

/**
 * Estilos cuando los campos son Incorrectos
 * -> Vacios
 * -> Incorrectos
 */
function styleError(el){
  $(el).css("background","#fbcaca");
  $(el).css("box-shadow", "0px 0px 0px 1px #ff0000");
}

/**
 * Estilos cuando los campos son correcto
 */
function styleCorrecto(el){
  $(el).css("background","none");
  $(el).css("box-shadow", "none");
}

/**
 * Funcionalidad a checkbox para seleccionar todo lo de una lista
 * usando el atributo "data-chk" para identificarlo
 */
function chechboxAll(){
  $('input[data-chk]').each(function(){
    var nombreChk=$(this).data("chk");
    $(this).click(function(event){
      if (event.target.checked) {
        $('input[data-chkname='+nombreChk+']').each(function(){
          $(this).prop("checked", true );
        });
      } else {
        $('input[data-chkname='+nombreChk+']').each(function(){
          $(this).prop("checked", false );
        });
      }
    });

  });
}

/**
 * Modal generico para alerta de mensajes
 * se crea boton y modal dinamico y se agrega en body
 * cada que se ejecuta, borra el modal anterior y crea otro
 * para no dejar basura
 */
function msgAlert(titulo, mensaje){
  //Removemos lo creado anteriormente
  $('#btnTmp').remove();
  $('#modalAlert').remove();

  //Creamos boto temporal para modal
  $('<button/>', {
    'id':           'btnTmp',
    'type':         'button',
    'class':        'btn btn-primary',
    'data-toggle':  'modal',
    'data-target':  '#modalAlert',
    'style':        'display:none'
  }).appendTo('body');

  //Creamos modal
  $('body').append(
    '<div class="modal fade" id="modalAlert" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">'+
      '<div class="modal-dialog" role="document">'+
        '<div class="modal-content">'+
          '<div class="modal-header">'+
            '<h5 class="modal-title" id="exampleModalLabel">'+titulo+'</h5>'+
            '<button type="button" class="close" data-dismiss="modal" aria-label="Close">'+
              '<span aria-hidden="true">&times;</span>'+
            '</button>'+
          '</div>'+
          '<div class="modal-body">'+mensaje+'</div>'+
          '<div class="modal-footer">'+
            '<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>'+
            '<button type="button" class="btn btn-secondary" data-dismiss="modal">Aceptar</button>'+
          '</div>'+
        '</div>'+
      '</div>'+
    '</div>' );
    $('#btnTmp').trigger('click');
}


/**
 * Bloque de carga de pantalla
 */
function bloqueo(){
  $('#bkimg').css('display','block');
	$('#fade').css('display','block');
}

/**
 * Desbloque de carga de pantalla
 */
function desbloqueo(){
  $('#bkimg').css('display','none');
	$('#fade').css('display','none');
}

function pruebaMensaje(){
  msgAlert("Titulo prueba", "Este es un mensaje de prueba para ver la capacidad del modal en alerts");
}

/**
 * formate campo numerico a moneda
 *
 */
function formateCantidad(howmuch, tipoAttr){
    var money = howmuch;
    var money2, sign;
    if (tipoAttr == "moneda") {
      if (money == "" || money == undefined) return "$ 0";
    }
    //-$ 555,555,555.55 kitar formato
    money = money.replace(/\$/g, "");
    money = money.replace(/ /g, "");
    money = money.replace(/,/g, "");
    money = money.replace(/[A-Z,a-z]/g, "");
    //-5555555.5555555 recibimos as�
    if (money.charAt(0) == "-") //es negativo
    {
      money = money.substr(1); //kitar el signo
      sign = "-";
    }
    else
    sign = "";
    if (money.indexOf(".") >= 0) //tiene decimales
    {
      moneyDec = "" + (Math.round(parseFloat(money.substr(money.indexOf(".")))*100)/100); //redondear
      moneyDec = moneyDec.substr(1); //kitar el 0 inicial de 0.12
      if (moneyDec.length == 2) moneyDec += "0"; //le falta un 0
    }
    else
    {
      moneyDec = "";
    }
    var moneyInt;
    if (money.indexOf(".") == -1)
    moneyInt = money; //si no tiene decimales es un entero
    else
    moneyInt = money.substr(0, money.indexOf(".")); //espaciar enteros solamente
    var i = moneyInt.length; //empezar al final
    var moneyCommas = "";
    var comma = "";
    while (1)
    {
      //contar 3 para atras
      if (i - 3 >= 0)
      ss = moneyInt.substr(i - 3, 3);
      else
      ss = moneyInt.substr(0, i); //si es igual a 2 entonces desde el principio tomar 2
      moneyCommas = ss + comma + moneyCommas;
      i = i - 3;
      if (comma == "") comma = ","; //la primera vuelta no necesita comma
      if (i == 0 ) comma = ""; //si es el ultimo no necesita comma
      if (i < 0) break; //ya se paso
    }
    money2 = moneyCommas + moneyDec;
    if (tipoAttr == "moneda") {
      money2 = sign + "$ " + money2;
    } else {
      money2 = sign + money2;
    }
    return money2;
}
