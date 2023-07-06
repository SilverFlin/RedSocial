class UserLogged {
  constructor (email, password) {
    this._email = email
    this._password = password
  }
  get email () {
    return this._email
  }
  get password () {
    return this._password
  }
  set email (email) {
    this._email = email
  }
  set password (password) {
    this._password = password
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

const guardarUsuario = () => {
  const botonGuardar = document.getElementById('user-form-btn')
  botonGuardar.disabled = true
  const txtEmail = getEmail()
  const txtPassword = getPassword()
  const userLog = new UserLogged(txtEmail, txtPassword)
  return userLogger
}

const guardar = () => {
  const botonGuardar = document.getElementById('user-form-btn')
  botonGuardar.onclick = guardarUsuario
}

window.onload = function () {
  guardar()
}
