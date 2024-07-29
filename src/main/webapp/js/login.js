function validarFormulario() {
  let identificacion = document.getElementById("identificacion");
  let password = document.getElementById("password");
  let msj = "";

  if (identificacion.value === "") {
    msj = "Por favor ingrese la identificación </br>";
    identificacion.style.borderColor = "#e7554a";
  } else {
    identificacion.style.borderColor = "#107c41";
  }

  if (password.value === "") {
    msj += "Por favor ingrese el password</br>";
    password.style.borderColor = "#e7554a";
  } else {
    password.style.borderColor = "#107c41";
  }

  if (msj != "") {
    mostrarModal(msj, "Inicio Sesión", "error");
  }else{
    document.getElementById("btn_accion").click();
  }

}

function mostrarModal(msj, titulo, icon) {
  Swal.fire({
    title: titulo,
    html: msj,
    icon: icon,
  });
}
