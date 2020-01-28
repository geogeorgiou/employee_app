// validator for all input fields
// with jQuery checks for "rules"
// and returns corresponding error "messages"

// used in /register

jQuery.validator.addMethod("lettersonly", function(value, element) {
    return this.optional(element) || /^[a-z ]+$/i.test(value);
}, "Enter letters only!");

jQuery(function ($){

    const usrValidator = $('#userForm');

    if (usrValidator.validate) {
        usrValidator.validate({
            rules: {

                email: {
                    required: true,
                    email: true
                },
                logName: {
                    required: true,
                    lettersonly: true
                },
                role: {
                    required: true
                },
                password: {
                    required: true,
                    minlength: 8
                }

            },
            messages: {

                email: {
                    required: 'Enter email 📧!',
                    email: "Enter valid email format!"
                },
                logName: {
                    required: 'Enter name!',
                    lettersonly: 'Enter letters only'
                },
                role: {
                    required: 'Enter role!'
                },
                password: {
                    required: 'Enter password',
                    minlength: 'Password should be at least 8 chars in length'
                }

            }
        });
    }

});

