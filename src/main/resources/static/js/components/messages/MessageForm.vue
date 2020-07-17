<template>
    <v-layout row>
        <v-text-field label="New message"
                      placeholder="Write something"
                      v-model="text"
                      @keyup.enter="save"
        />
        <v-btn @click="save">
            Save
        </v-btn>
    </v-layout>
</template>

<script>
    import { mapActions } from 'vuex'

    export default {
        props: ['messageAttribute'],
        data() {
            return {
                text: '',
                id: ''
            }
        },
        watch: {
            messageAttribute(newValue, oldValue) {
                this.text = newValue.text
                this.id = newValue.id
            }
        },
        methods: {
            ...mapActions(['addMessageAction', 'updateMessageAction']),
            save() {
                const message = {
                    id: this.id,
                    text: this.text
                }

                if (this.id) {
                    this.updateMessageAction({
                        id: this.id,
                        text: this.text
                    });
                } else {
                    this.addMessageAction({
                        text: this.text
                    });
                }

                this.text = ''
                this.id = ''
            }
        }
    }
</script>

<style>

</style>