class PostEdited {
  constructor (title, content, file) {
    this._title = title
    this._content = content
    this._file = file
  }

  get title () {
    return this._title
  }
  get content () {
    return this._content
  }
  get file () {
    return this._file
  }
  set title (title) {
    this._title = title
  }
  set content (content) {
    this._content = content
  }
  set file (file) {
    this._file = file
  }
}

const valorElemento = function (id) {
  return (element = document.getElementById(id))
}

const getTitle = () => {
  return valorElemento('title-text').value
}

const getContent = () => {
  return valorElemento('content').value
}

const getFile = () => {
  return valorElemento('file').src
}

const guardarPostEdited = () => {
  const botonGuardar = document.getElementById('boton')
  botonGuardar.disabled = true
  const txtTitle = getTitle()
  const txtContent = getContent()
  const file = getFile()
  const postEdited = new PostEdited(txtTitle, txtContent, file)
  return postEdited
}

const guardar = () => {
  const botonGuardar = document.getElementById('boton')
  botonGuardar.onclick = guardarPostEdited
}

window.onload = function () {
  guardar()
}
