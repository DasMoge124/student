const dotenv = require('dotenv');
dotenv.config();

const apiKey = process.env.API_KEY;
const dbUrl = process.env.DATABASE_URL;
const api = process.env.API;

console.log('API Key:', api)
console.log('Database URL:',dbUrl)