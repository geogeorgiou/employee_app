// validator for all input fields
// with jQuery checks for "rules"
// and returns corresponding error "messages"

// used in /user/home + /register

jQuery(function ($){

    const userValidator = $('#userValidator');

    if (userValidator.validate) {
        userValidator.validate({
            rules: {

                firstName: {
                    required: true
                },
                lastName: {
                    required: true
                },
                email: {
                    required: true,
                    email: true
                },

                password:{
                    required: true,
                    minlength: 8
                },


                confirm_password:{
                    required: true,
                    minlength: 8,
                    equalTo: "#password"
                },

                phoneNumber: {
                    digits: true,
                    minlength: 10,
                    maxlength: 10
                },

            },
            messages: {

                email: {
                    required: 'Enter your email! 📧',
                },
                firstName: {
                    required: 'Enter your first name'
                },
                lastName: {
                    required: 'Enter your last name'
                },
                password: {
                    required: 'Enter your password',
                    minlength: 'Password should be more than 8 characters',
                },

                confirm_password:{
                    required: 'Re-enter password',
                    minlength: 'Password should be more than 8 characters',
                    equalTo: 'Please enter the same password'
                },
                phoneNumber: {
                    minlength: 'Phone number should be 10 digits',
                    maxlength: 'Phone number should be 10 digits',
                    digits: 'Phone number should contain only digits'
                },

            }
        });
    }


});

