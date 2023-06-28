<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="/webapp/assets/css/users/edit-profile.css" />
        <title>Edit Profile</title>
    </head>

    <body>
        <form class="edit-profile-form" action="/webapp/edit-user?action=edit" method="POST">
            <h1>Edit profile</h1>
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
                          />
                    </div>
                    <div>
                        <label for="gender">Gender</label>
                        <select name="gender" id="gender" class="input-edit-form" required>
                            <option selected value="">Select...</option>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="other">Other</option>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-item-col3">
                        <label for="city"> City </label>
                        <input type="text" name="city"  id="city" placeholder="Obregon" />
                    </div>
                    <div class="form-item-col3">
                        <label for="municipality"> Municipality </label>
                        <input type="text" name="municipality" id="municipality" placeholder="Cajeme" />
                    </div>
                    <div class="form-item-col3">
                        <label for="state"> State </label>
                        <input type="text" name="state" id="state" placeholder="Sonora" />
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
                    </div>
                </div>
            </div>
            <button type="submit" class="save-btn">SAVE</button>
        </form>
    </body>
</html>

