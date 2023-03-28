<template>

    <v-data-table
        :headers="headers"
        :items="foodproclist"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'FoodproclistView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            foodproclist : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/foodproclists'))

            temp.data._embedded.foodproclists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.foodproclist = temp.data._embedded.foodproclists;
        },
        methods: {
        }
    }
</script>

