class User {

  constructor (email, password, confirmPassword) {
    this._email = email
    this._password = password
    this._confirmPassword = confirmPassword
  }

  get email () {
    return this._email
  }
  set email (nuevoEmail) {
    this._email = nuevoEmail
  }
  get password () {
    return this._password
  }
  set password (newPassword) {
    this._password = newPassword
  }
  get confirmPassword () {
    return this._confirmPassword
  }
  set confirmPassword (confirmPassword) {
    this._confirmPassword = confirmPassword
  }
}

const valorElemento = function (id) {
  return (element = document.getElementById(id))
}
const getEmail = () => {
  return valorElemento('email').value
}
const getPassword = () => {
  return valorElemento('password').value
}
const getConfirmPassword = () => {
  return valorElemento('confirmPassword').value
}
const guardarUsuario = () => {
  const botonGuardar = valorElemento('userformbtn')
  botonGuardar.disabled = true
  const email = getEmail()
  const password = getPassword()
  const confirmPassword = getConfirmPassword()
  const usuarioRegistrar = new User(email, password, confirmPassword)
  return usuarioRegistrar
}

const guardar = () => {
  const botonGuardar = document.getElementById('userformbtn')
  botonGuardar.onclick = guardarUsuario
}

window.onload = function () {
  guardar()
}