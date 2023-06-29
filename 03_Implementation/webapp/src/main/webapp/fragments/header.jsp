<head>
    <link rel="stylesheet" href="/webapp/assets/css/fragments/header.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
</head>
<header class="header">
    <!-- Form that contain the options of the form -->
    <form action="" class="options-form">
        <!-- Div whose button that allow navegate back in the web -->
        <div class="content">
            <button id="button-left">
                <!-- Icon -->
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="32"
                  height="32"
                  viewBox="0 0 32 32"
                  >
                    <path
                      fill="currentColor"
                      d="M16 3C8.832 3 3 8.832 3 16s5.832 13 13 13s13-5.832 13-13S23.168 3 16 
                      3zm0 2c6.087 0 11 4.913 11 11s-4.913 11-11 11S5 22.087 5 16S9.913 5 16 
                      5zm-.72 4.594L9.595 15.28l-.72.72l.72.72l5.687 5.686L16.72 
                      21l-4-4H23v-2H12.72l4-4l-1.44-1.406z"
                      />
                </svg>
            </button>
            <span>Hey, ${sessionScope.user.email}</span>
        </div>

        <div class="content" id="search-container">
            <input type="text" placeholder="Search" />
            <button id="button-search">
                <svg
                  id="magnifying-glass-image"
                  xmlns="http://www.w3.org/2000/svg"
                  width="12"
                  height="12"
                  viewBox="0 0 256 256"
                  >
                    <path
                      d="m226.83 
                      221.17l-52.7-52.7a84.1 84.1 0 1 0-5.66 5.66l52.7 
                      52.7a4 4 0 0 0 5.66-5.66ZM36 112a76 76 
                      0 1 1 76 76a76.08 76.08 0 0 1-76-76Z"
                      />
                </svg>
            </button>
        </div>

        <div class="content" id="buttons-pair">
            <a href="/webapp/edit-user"> 

                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="24"
                  height="24"
                  viewBox="0 0 24 24"
                  >
                    <path
                      fill="currentColor"
                      d="M12 4a4 4 0 0 1 4 4a4 4 0 0 1-4
                      4a4 4 0 0 1-4-4a4 4 0 0 1 4-4m0 10c4.42 0 8 1.79 8 4v2H4v-2c0-2.21 3.58-4 8-4Z"
                      />
                </svg>


            </a>
            <a href="/webapp/auth?action=logout">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="24"
                  height="24"
                  viewBox="0 0 24 24"
                  >
                    <g
                      fill="none"
                      stroke="currentColor"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      >
                        <path
                          d="M14 8V6a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h7a2 2 0 0 0 2-2v-2"
                          />
                        <path d="M9 12h12l-3-3m0 6l3-3" />
                    </g>
                </svg>

            </a>
        </div>
    </form>
</header>
