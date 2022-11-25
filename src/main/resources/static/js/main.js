var messageApi = Vue.resource('/message{/id}');

Vue.component('message-row', {
    props: ['message'],
   template: '<div><i>({{ message.id }})</i>{{ message.text }}</div>'
});

//цикл по обходу и выводу месседжей
Vue.component('messages-list', {
    props: ['messages'],
    template: '<div> <message-row v-for="message in messages" :key="message.id" :message="message" /></div>',
    created: function () {
        messageApi.get().then(result =>
            result.json().then(data =>
                data.forEach(message => this.messages.push(message))
            )
        )
    }
})

var app = new Vue({
    el: '#app',
    template: '<messages-list :messages="messages" />',
    data: {
        messages: [
            /*{ id: '123', text: 'Wow' },
            { id: '23', text: 'More' },
            { id: '3', text: 'Another'} ,*/
            /*Тестовые месседжи*/
        ]
    }
});