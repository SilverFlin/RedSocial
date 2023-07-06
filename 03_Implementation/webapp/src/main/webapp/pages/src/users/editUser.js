class userEditer {
  constructor (
    firstName,
    lastName,
    email,
    phoneNumber,
    birthDay,
    gender,
    city,
    municipality,
    state,
    imageProfile
  ) {
    this._firstName = firstName
    this._lastName = lastName
    this._email = email
    this._phoneNumber = phoneNumber
    this._birthDay = birthDay
    this._gender = gender
    this._city = city
    this._municipality = municipality
    this._state = state
    this._imageProfile = imageProfile
  }
  get firstName () {
    return this._firstName
  }
  get lastName () {
    return this._lastName
  }
  get email () {
    return this._email
  }
  get phoneNumber () {
    return this._phoneNumber
  }
  get birthDay () {
    return this._birthDay
  }
  get gender () {
    return this._gender
  }
  get city () {
    return this._city
  }
  get municipality () {
    return this._municipality
  }
  get state () {
    return this._state
  }
  get imageProfile () {
    return this._imageProfile
  }

  set firstName (firstName) {
    this._firstName = firstName
  }
  set lastName (lastName) {
    this._lastName = lastName
  }
  set email (email) {
    this._email = email
  }
  set phoneNumber (phoneNumber) {
    this._phoneNumber = phoneNumber
  }
  set birthDay (birthDay) {
    this._birthDay = birthDay
  }
  set gender (gender) {
    this._gender = gender
  }
  set city (city) {
    this._city = city
  }
  set municipality (municipality) {
    this._municipality = municipality
  }
  set state (state) {
    this._state = state
  }
  set imageProfile (imageProfile) {
    this._imageProfile = imageProfile
  }
}

const getFirstName = () => {
  return valorElemento('first-name').value
}

const getLastName = () => {
  return valorElemento('last-name').value
}

const getEmail = () => {
  return valorElemento('email').value
}
const getPhoneNumber = () => {
  return valorElemento('phone-number').value
}
const getBirthDay = () => {
  return valorElemento('birthday').textContent
}

const getGenderSelected = () => {
  const selGender = document.getElementById('gender')
  const selectedGender = selGender.options[selGender.selectedIndex].value
  return selectedGender
}

const getCity = () => {
  return valorElemento('city').value
}

const getMunicipality = () => {
  return valorElemento('municipality').value
}
const getState = () => {
  return valorElemento('state').value
}
const getImageProfile = () => {
  return valorElemento('profile-picture').src
}

const guardarUsuarioEditado = () => {
  const botonGuardar = valorElemento('save-btn')
  botonGuardar.disabled = true
  const firstName = getFirstName()
  const lastName = getLastName()
  const email = getEmail()
  const phoneNumber = getPhoneNumber()
  const birthDay = getBirthDay()
  const gender = getGenderSelected()
  const city = getCity()
  const municipality = getMunicipality()
  const state = getState()
  const image = getImageProfile()

  const userEdited = new UserEdited(
    firstName,
    lastName,
    email,
    phoneNumber,
    birthDay,
    gender,
    city,
    municipality,
    state,
    image
  )
  console.table(userEdited)
}

const guardar = () => {
  const botonGuardar = document.getElementById('save-btn')
  botonGuardar.onclick = guardarUsuarioEditado
}

window.onload = function () {
  guardar()
}
