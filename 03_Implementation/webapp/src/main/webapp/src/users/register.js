class User {
  constructor (email, password, confirmPassword) {
    this.email = email
    this.password = password
    this.confirmPassword = confirmPassword
  }
}

const getEmail = () => {
  const inputEmail = document.getElementById('email').value
  return inputEmail
}
const getPassword = () => {
  const inputPassword = document.getElementById('password').value
  return inputPassword
}
const getConfirmPassword = () => {
  const inputPasswordConfirm = document.getElementById('confirm-password').value
  return inputPasswordConfirm
}

const guardarUsuario = () => {
  const botonGuardar = document.getElementById('user-form-btn')
  botonGuardar.disabled = true
  const email = getEmail()
  const password = getPassword()
  const confirmPassword = getConfirmPassword()
  const usuarioRegistrar = new User(email, password, confirmPassword)
  return usuarioRegistrar
}

const guardar = () => {
  const botonGuardar = document.getElementById('user-form-btn')
  botonGuardar.onclick = guardarUsuario
}

window.onload = function () {
  guardar()
}
