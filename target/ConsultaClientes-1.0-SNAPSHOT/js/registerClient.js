function validarFormulario() {
  let nombre1 = document.getElementById("nombre_1");
  let apellido1 = document.getElementById("apellido_1");
  let apellido2 = document.getElementById("apellido_2");
  let identificacion = document.getElementById("identificacion");
  let tipo_identificacion = document.getElementById("id_Tipo_Identificacion");
  let direccion = document.getElementById("domicilio");
  let email = document.getElementById("email");
  let telefono = document.getElementById("telefono");
  let msj = "";

  if (nombre1.value === "") {
    msj = "Por favor ingrese el primer nombre </br>";
    nombre1.style.borderColor = "#e7554a";
  } else {
    nombre1.style.borderColor = "#107c41";
  }

  if (apellido1.value === "") {
    msj += "Por favor ingrese el primer apellido </br>";
    apellido1.style.borderColor = "#e7554a";
  } else {
    apellido1.style.borderColor = "#107c41";
  }

  if (apellido2.value === "") {
    msj += "Por favor ingrese el segundo apellido </br>";
    apellido2.style.borderColor = "#e7554a";
  } else {
    apellido2.style.borderColor = "#107c41";
  }

  if (identificacion.value === "") {
    msj += "Por favor ingrese la identificación </br>";
    identificacion.style.borderColor = "#e7554a";
  } else {
    identificacion.style.borderColor = "#107c41";
  }

  if (tipo_identificacion.value === "0") {
    msj += "Por favor ingrese el tipo de identificación </br>";
    tipo_identificacion.style.borderColor = "#e7554a";
  } else {
    tipo_identificacion.style.borderColor = "#107c41";
  }

  if (direccion.value === "") {
    msj += "Por favor ingrese la dirección </br>";
    direccion.style.borderColor = "#e7554a";
  } else {
    direccion.style.borderColor = "#107c41";
  }

  if (email.value === "") {
    msj += "Por favor ingrese el email </br>";
    email.style.borderColor = "#e7554a";
  } else {
    if(validarEmail(email.value)) {
        email.style.borderColor = "#107c41";
    }else{
        msj += "El email ingresado no tiene el formato correcto </br>";
        email.style.borderColor = "#e7554a";
    }    
  }

  if (telefono.value === "") {
    msj += "Por favor ingrese el teléfono </br>";
    telefono.style.borderColor = "#e7554a";
  } else {
    telefono.style.borderColor = "#107c41";
  }

  if (msj != "") {
    mostrarModal(msj, "Inicio Sesión", "error");
  } else {
        debugger;
    document.getElementById("btn_accion").click();
  }
}

function validarEmail(email) {
    // Expresión regular para validar el formato del correo electrónico
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    // Comprobar si el valor del email coincide con la expresión regular
    return regex.test(email);
}

function mostrarModal(msj, titulo, icon) {
  Swal.fire({
    title: titulo,
    html: msj,
    icon: icon
  });
}
