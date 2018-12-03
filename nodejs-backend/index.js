const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => res.send('Greetings from Node.js!'))

app.listen(port, () => console.log(`Greetings app listening on port ${port}!`))
