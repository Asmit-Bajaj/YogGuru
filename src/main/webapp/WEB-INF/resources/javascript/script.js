let temp = true;

function checkImage() {
    let image = document.getElementById('file');
    let imgSrc = document.querySelector('img');
    let imgRejex = /(\jpg|\jpeg|\png)$/i;
    
    let extention = image.files[0].type.split('/')[1];
    if (extention.match(imgRejex)) {
        if (image.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                imgSrc.setAttribute('src', e.target.result);
            };
            reader.readAsDataURL(image.files[0]);
        }
    }
    else {
        alert('Please provide an Valid image');
        fileInput.value = '';
    }
}

function checkBlogImages() {
    let image = document.getElementById('files');
    let imgRejex = /(\jpg|\jpeg|\png)$/i;

    for(let i=0;i<image.files.length;i++){
        //console.log(image.files[i].name);

        let extention = image.files[i].type.split('/')[1];
        if (extention.match(imgRejex)) {
            
        }else {
            alert('Please provide valid images with png/jpeg/jpg extension');
            image.value = '';
        }
    }
}

function checkVideo() {
    let video = document.getElementById('videofile');
    let videoRejex = /(\mp4)$/i;

    for(let i=0;i<video.files.length;i++){
        //console.log(image.files[i].name);

        let extention = video.files[i].type.split('/')[1];
        if (extention.match(videoRejex)) {
            
        }else {
            alert('Please provide valid video with mp4 extension');
            video.value = '';
        }
    }
}

function checkEmail() {
    let emailAlert = document.querySelector('.emailAlert');
    let emailRegex = /[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$/;
    let email = document.getElementById("email").value;
    if (email.match(emailRegex)) {
        document.getElementById("email").style.borderBottom = "2px solid rgb(175, 173, 173)";
        emailAlert.innerHTML = "";
        temp = true;
    }
    else {
        document.getElementById("email").style.borderBottom = "2px solid red";
        emailAlert.innerHTML = "Please provide a valid email";
        emailAlert.style.color = "#f00";
        temp = false;
    }
}
function checkPassword() {
    let passwordAlert = document.querySelector('.passAlert');
    let passwordRegex = new RegExp("^(?=.{8,})");
    let password = document.getElementById("password").value;
    if (password.match(passwordRegex)) {
        document.getElementById("password").style.borderBottom = "2px solid rgb(175, 173, 173)";
        passwordAlert.innerHTML = "";
        temp = true;
    }
    else {
        document.getElementById("password").style.borderBottom = "2px solid red";
        passwordAlert.innerHTML = "Please provide a 8 character long password";
        passwordAlert.style.color = "#f00";
        temp = false;
    }
}
function checkName() {
    let nameAlert = document.querySelector('.nameAlert');
    let nameRegex = /^[a-zA-Z ]{2,30}$/;
    let name = document.getElementById("name").value;
    if (name.match(nameRegex)) {
        document.getElementById("name").style.borderBottom = "2px solid rgb(175, 173, 173)";
        nameAlert.innerHTML = "";
        temp = true;
    }
    else {
        document.getElementById("name").style.borderBottom = "2px solid red";
        nameAlert.innerHTML = "Please provide a valid Name";
        nameAlert.style.color = "#f00";
        temp = false;
    }
}

function checkBlogTitle() {
    let nameAlert = document.querySelector('.nameAlert');
    let nameRegex = /^[a-zA-Z ]{1,}$/;
    let name = document.getElementById("blog_title").value;
    
    console.log(name);
    if (name.match(nameRegex)) {
        document.getElementById("blog_title").style.borderBottom = "2px solid rgb(175, 173, 173)";
        nameAlert.innerHTML = "";
        temp = true;
    }
    else {
        document.getElementById("blog_title").style.borderBottom = "2px solid red";
        nameAlert.innerHTML = "Please provide a valid Title";
        nameAlert.style.color = "#f00";
        temp = false;
    }
    //document.getElementById("blog_title").value = name;
}

function checkContact() {
    let contactAlert = document.querySelector('.contactAlert');
    let contactRegex = /^\d{10}$/;
    let contact = document.getElementById("contact").value;
    if (contact.match(contactRegex)) {
        document.getElementById("contact").style.borderBottom = "2px solid rgb(175, 173, 173)";
        contactAlert.innerHTML = "";
        temp = true;
    }
    else {
        document.getElementById("contact").style.borderBottom = "2px solid red";
        contactAlert.innerHTML = "Please provide a valid Contact";
        contactAlert.style.color = "#f00";
        temp = false;
    }
}

function checkAddress() {
    let addressAlert = document.querySelector('.addressAlert');
    let address = document.getElementById("address").value;
    let addressRegex = new RegExp("^(?=.{2,})");

    if (address.match(addressRegex)) {
        document.getElementById("address").style.borderBottom = "2px solid rgb(175, 173, 173)";
        addressAlert.innerHTML = "";
        temp = true;
    }
    else {
        document.getElementById("address").style.borderBottom = "2px solid red";
        addressAlert.innerHTML = "Please provide a address";
        addressAlert.style.color = "#f00";
        temp = false;

    }
}


function checkBlogDesc() {
    let addressAlert = document.querySelector('.addressAlert');
    let address = document.getElementById("blog_desc").value;
    let addressRegex = new RegExp("^(?=.{1,})");

    if (address.match(addressRegex)) {
        document.getElementById("blog_desc").style.borderBottom = "2px solid rgb(175, 173, 173)";
        addressAlert.innerHTML = "";
        temp = true;
    }
    else {
        document.getElementById("blog_desc").style.borderBottom = "2px solid red";
        addressAlert.innerHTML = "Please provide valid Description";
        addressAlert.style.color = "#f00";
        temp = false;

    }
}

function checkState(e) {
    let stateAlert = document.querySelector('.stateAlert');
    let state = document.getElementById("State").value;
    let cityAlert = document.querySelector('.cityAlert');
    let city = document.getElementById("City").value;

    let states = {
        AndhraPradesh: ["Hyderabad ", "Amaravati ", "Visakhapatnam", "Vijayawada", "Guntur", "Nellore", "Tirupati"],
        ArunachalPradesh: ["Itanagar", "Tawang", "Bhismaknagar", "Pasighat", "Ziro", "Bomdila", "other"],
        Assam: ["Dispur", "Guwahati", "Tezpur", "Dibrugarh", "Silchar", "North Lakhimpur", "other"],
        Bihar: ["Patna", "Gaya", "Biharsharif", "Darbhanga", "Bhagalpur", "other"],
        Chhattisgarh: ["Raipur", "Bilaspur", "Korba", "Durg-Bhilainagar", "Raigarh", "Rajnandgaon", "other"],
        Goa: ["Panaji", "Vasco-da-Gama", "Ponda", "Margao", "Mapusa", "Goa Velha", "other"],
        Gujarat: ["Gandhinagar", "Ahmedabad", "Surat", "Rajkot", "Junagadh", "Vadodara", "other"],
        Haryana: ["Faridabad", "Gurgaon", "Sonipat", "Panipat", "Ambala", "other"],
        HimachalPradesh: ["Shimla", "Dharamshala", "Mandi", "Solan", "Bilaspur", "Chamba", "other"],
        Jharkhand: ["Ranchi", "Bokaro Steel City", "Jamshedpur", "Deoghar", "Hazaribagh", "Dhanbad", "other"],
        Karnataka: ["Bengaluru", "Mysore", "Davangere", "Mangalore", "Hubli-Dharwad", "Belgaum", "other"],
        Kerala: ["Thiruvananthapuram", "Kochi", "Kozhikode", "Thrissur", "Malappuram", "other"],
        MadhyaPradesh: ["Bhopal", "Indore", "Gwalior", "Jabalpur", "Ujjain", "Sagar", "other"],
        Maharashtra: ["Mumbai", "Pune", "Nagpur", "Nashik", "Aurangabad", "Solapur", "other"],
        Manipur: ["Imphal", "Bishnupur", "Ukhrul", "Tamenglong", "Chandel", "Senapati", "other"],
        Meghalaya: ["Shillong", "Cherrapunji", "Tura", "Jowai", "Baghmara", "Nongpoh", "other"],
        Mizoram: ["Aizawl", "Lunglei", "Serchhip", "Champhai", "Tuipang", "Mamit", "other"],
        Nagaland: ["Kohima", "Tuensang", "Zunheboto", "Mokokchung", "Kiphire Sadar", "Phek", "other"],
        Odisha: ["Bhubaneswar", "Rourkela", "Cuttack", "Brahmapur", "Puri", "Sambalpur", "other"],
        Punjab: ["Chandigarh", "Amritsar", "Jalandhar", "Ludhiana", "Patiala", "Kapurthala", "other"],
        Rajasthan: ["Jaipur", "Bikaner", "Jaisalmer", "Jodhpur", "Udaipur", "Ajmer", "other"],
        Sikkim: ["Gangtok", "Namchi", "Gyalshing", "Mangan", "Rabdentse", "other"],
        TamilNadu: ["Chennai", "Tiruchirappalli", "Madurai", "Erode", "Vellore", "Coimbatore", "other"],
        Telangana: ["Hyderabad", "Warangal", "Nizamabad", "Karimnagar", "Adilabad", "Khammam", "other"],
        Tripura: ["Agartala", "Amarpur", "Kumarghat", "Udaipur", "Gakulnagar", "Kunjaban", "other"],
        UttarPradesh: ["Lucknow", "Noida", "Varanasi", "Allahabad", "Agra", "Kanpur", "other"],
        Uttarakhand: ["Dehradun", "Haridwar", "Roorkee", "Rishikesh", "Kashipur", "Haldwani", "other"],
        WestBengal: ["Kolkata", "Darjeeling", "Siliguri", "Asansol", "Howrah", "Durgapur", "other"],

    }
    if (e.length == 0) {
        document.getElementById("City").innerHTML = "<option></option>";
        document.getElementById("City").style.borderBottom = "2px solid red";
        cityAlert.innerHTML = "Please provide a address";
        cityAlert.style.color = "#f00";
        document.getElementById("State").style.borderBottom = "2px solid red";
        StateAlert.innerHTML = "Please provide a address";
        StateAlert.style.color = "#f00";
        temp = true;
    }
    else {
        let cities = "";
        for (i in states[e]) {
            cities += "<option>" + states[e][i] + "</option>";
        }
        document.getElementById("City").innerHTML = cities;
        document.getElementById("State").style.borderBottom = "2px solid rgb(175, 173, 173)";
        stateAlert.innerHTML = "";
        document.getElementById("City").style.borderBottom = "2px solid rgb(175, 173, 173)";
        cityAlert.innerHTML = "";
        temp = false;

    }

}

function submission() {
    let flag = true;
    var inputValue = document.getElementsByClassName('form-control');
    var inputAlert = document.querySelectorAll('.alert');
    let x;
    for (i = 0; i < inputValue.length; i++) {
        if (inputValue[i].value == "" || inputValue[i].value == null) {
            flag = false;
            inputValue[i].style.borderBottom = "2px solid #f00";
            inputAlert[i].innerHTML = "Please fill this field";
            inputAlert[i].style.color = "#f00";

        }
        else {
            x = inputValue[i].getAttribute('id');
            if (x == 'email') {
                checkEmail();
                if (temp == false) {
                    flag = false;
                    break;
                } else if (flag == true) {
                    flag = true;
                }
            } else if (x == 'password') {
                checkPassword();
                if (temp == false) {
                    flag = false;
                    break;
                } else if (flag == true) {
                    flag = true;
                }
            } else if (x == 'name') {
                checkName();
                if (temp == false) {
                    flag = false;
                    break;
                } else if (flag == true) {
                    flag = true;
                }
            } else if (x == 'contact') {
                checkContact();

                if (temp == false) {
                    flag = false;
                    break;
                } else if (flag == true) {
                    flag = true;
                }
            } else if (x == 'address') {
                checkAddress();
                if (temp == false) {
                    flag = false;
                    break;
                } else if (flag == true) {
                    flag = true;
                }
            }
            else if (x == 'State') {
                checkState();
                if (temp == false) {
                    flag = false;
                    break;
                } else if (flag == true) {
                    flag = true;
                }
            }else if(x == 'blog_title'){
            	checkBlogTitle();
                if (temp == false) {
                    flag = false;
                    break;
                } else if (flag == true) {
                    flag = true;
                }
            }else if(x == 'blog_desc'){
            	checkBlogDesc();
                if (temp == false) {
                    flag = false;
                    break;
                } else if (flag == true) {
                    flag = true;
                }
            }
        }
    }


    return flag;
}


