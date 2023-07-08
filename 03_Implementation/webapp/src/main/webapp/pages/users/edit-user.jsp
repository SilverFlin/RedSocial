<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="/webapp/assets/css/users/edit-profile.css" />
        <title>Edit Profile</title>
    </head>

    <body>
        <h1 id="title-form">Edit profile</h1>
        <form class="edit-profile-form" action="/webapp/edit-user?action=edit" method="POST" enctype="multipart/form-data">
            <div class="form-container">
                <div class="form-row">
                    <div>
                        <label for="first-name"> First Name </label>
                        <input
                          type="text"
                          name="first-name"
                          id="first-name"
                          class="input-edit-form"
                          placeholder="John"
                          value="${sessionScope.user.nombreCompleto.nombres}"
                          pattern="^[a-zA-Z]+$"
                          required
                          />
                    </div>
                    <div>
                        <label for="last-name"> Last Name </label>
                        <input
                          type="text"
                          name="last-name"
                          id="last-name"
                          class="input-edit-form"
                          placeholder="Doe"
                          value="${sessionScope.user.nombreCompleto.apellidoPaterno}"
                          pattern="^[a-zA-Z]+$"
                          required
                          />
                    </div>
                </div>
                <div class="form-row">
                    <div>
                        <label for="email"> Email * </label>
                        <input
                          type="email"
                          name="email"
                          id="email"
                          class="input-edit-form"
                          placeholder="John@Doe.com"
                          required
                          value="${sessionScope.user.email}"
                          disabled
                          />
                    </div>
                    <div>
                        <label for="phone-number"
                               >Phone number
                            <span id="phone-number-span">(10 digits)</span></label
                        >
                        <input
                          type="text"
                          name="phone-number"
                          id="phone-number"
                          class="input-edit-form"
                          placeholder="1234567890"
                          minlength="10"
                          maxlength="10"
                          value="${sessionScope.user.telefono}"
                          pattern="[0-9]{10}"
                          />
                    </div>
                </div>
                <div class="form-row">
                    <div>
                        <label for="birthday">Birthday</label>
                        <input
                          type="date"
                          name="birthday"
                          id="birthday"
                          class="input-edit-form"
                          value="${sessionScope.user.fechaNacimiento.year}-${sessionScope.user.fechaNacimiento.monthValue < 10 ? '0' : ''}${sessionScope.user.fechaNacimiento.monthValue}-${sessionScope.user.fechaNacimiento.dayOfMonth < 10 ? '0' : ''}${sessionScope.user.fechaNacimiento.dayOfMonth}"
                          />
                    </div>
                    <div>
                        <label for="gender">Gender</label>
                        <select name="gender" id="gender" class="input-edit-form" required>
                            <option selected value="">Select...</option>
                            <option value="male" ${sessionScope.user.genero == 'MASCULINO'?'selected':''} >Male</option>
                            <option value="female" ${sessionScope.user.genero == 'FEMENINO'?'selected':''}>Female</option>
                            <option value="other" ${sessionScope.user.genero == 'OTRO'?'selected':''}>Other</option>
                        </select>
                        <!--${sessionScope.user.genero}-->
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-item-col3">
                        <label for="city"> City </label>
                        <input type="text" name="city"  id="city" placeholder="Obregon" value="${sessionScope.user.direccion.ciudad}" pattern="^[a-zA-Z]+$" />
                       
                    </div>
                    <div class="form-item-col3">
                        <label for="municipality"> Municipality </label>
                        <input type="text" name="municipality" id="municipality" placeholder="Cajeme" value="${sessionScope.user.direccion.municipio}" pattern="^[a-zA-Z]+$" />
                        
                    </div>
                    <div class="form-item-col3">
                        <label for="state"> State </label>
                        <input type="text" name="state" id="state" placeholder="Sonora" value="${sessionScope.user.direccion.estado}" pattern="^[a-zA-Z]+$"/>
                        
                    </div>
                </div>
                <div class="form-row">
                    <div>
                        <label for="profile-picture">Profile Picture</label>
                        <input
                          type="file"
                          accept="image/*"
                          name="profile-picture"
                          id="profile-picture"
                          class="input-edit-form"
                          />
                        <c:if test="${sessionScope.user.avatar != null}">
                            <img id="edit-profile-picture" src="/webapp/pictures?action=avatar&id=${sessionScope.user.id}" alt="alt"/>
                        </c:if>
                    </div>

                </div>
            </div>
            <button type="submit" class="save-btn">SAVE</button>
        </form>
    </body>
</html>

