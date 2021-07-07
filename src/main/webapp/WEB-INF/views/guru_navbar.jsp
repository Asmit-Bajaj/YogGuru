<nav class="navbar navbar-expand-lg ">
            <span class="navbar-brand home-nav-header">YogGuru</span>
            <button class="navbar-dark navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation" style="border:1px solid #44b3fd; color:white; background:#6DD5FA;">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">

                <ul class="navbar-nav mr-auto ">
                    <li class="nav-item home-nav-li" active>
                        <a class="nav-link home-nav-content" aria-current="page" href="/YogGuru/Guru">Home</a>
                    </li>
                    <li class="nav-item home-nav-li">
                        <a class="nav-link home-nav-content" href="/YogGuru/Guru/MyBlogs">My Blogs</a>
                    </li>
                    
                     <li class="nav-item home-nav-li">
                        <a class="nav-link home-nav-content" href="/YogGuru/Guru/MyVideos">My Videos</a>
                    </li>
					
					<li class="nav-item home-nav-li">
                        <a class="nav-link home-nav-content" href="/YogGuru/Guru/MyChats">My Chats</a>
                    </li>
					
					
                </ul>
                
                <li class="nav-item home-nav-li">
                    <a type="button" class="nav-link home-nav-content sign-in-link" data-bs-toggle="modal" data-bs-target="#logOutModal">Log Out</a>
                </li>
                
            </div>

</nav>

<div class="modal fade" id="logOutModal" data-bs-backdrop="static" data-bs-keyboard="false" 
tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Log Out</h5>
        
      </div>
      <div class="modal-body">
        Are You Sure You Want To Log Out ?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
        <a type="button" class="btn btn-primary" href="/YogGuru/LogOut">Yes</a>
      </div>
    </div>
  </div>
</div>