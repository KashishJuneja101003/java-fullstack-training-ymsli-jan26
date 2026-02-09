# MODULE: Advance Spring Boot Microservices Development

© 2026 Busycoder Academy. All rights reserved.

This assignment material is the intellectual property of Busycoder Academy and is provided strictly for classroom training conducted by the trainer.

This content is not intended for self-study distribution or public reuse.

---

# Assignment 4 – MEAN Stack CRUD

### Instructions to Students

You are required to create a **ProductStore CRUD application** using the **MEAN stack**.

You must **refer to the below Book Management CRUD application** as a reference implementation.

- Use it only as a **guideline**
- Change the domain from **Book** to **Product**
- Design your own schema, routes, and UI accordingly
- **Do NOT use ChatGPT**
- **Do NOT use Google**
- Rely only on:
  - This reference
  - Your understanding
  - Classroom discussions

---

## Reference Application (Book CRUD – MEAN Backend)

Complete code:
-----------

### Book.model.js
----------------
```js
var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var BookSchema = new Schema({
  title: String,
  author: String,
  category: String
});

module.exports = mongoose.model('Book', BookSchema);
app.js
js
Copy code
const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const Book = require('./Book.model');

const app = express();
const port = 8080;
const dbURI = 'mongodb://localhost:27017/rajdb33'; // Better to specify port

// Middleware
//अगर HTTP request body JSON format में आई है, तो उसे parse करके JavaScript object बना दो.”
app.use(bodyParser.json());

//बिना bodyParser.urlencoded() के, HTML form से भेजा गया data req.body में नहीं मिलेगा.
app.use(bodyParser.urlencoded({ extended: true }));

// Connect to MongoDB using modern promise-based approach
mongoose.connect(dbURI)
  .then(() => console.log('MongoDB connected...'))
  .catch(err => console.error('MongoDB connection error:', err));

// Root route
app.get('/', (req, res) => {
  res.send('happy to be here');
});

// Get all books
//This Express route asynchronously fetches all books from MongoDB
// using Mongoose and returns them as a JSON response without blocking the event loop

app.get('/book', async (req, res) => {
  try {
    const books = await Book.find({});
    res.setHeader('Cache-Control', 'no-cache, no-store');
    res.json(books);
  } catch (err) {
    res.status(500).send(err.message);
  }
});

// Get book by ID
app.get('/book/:id', async (req, res) => {
  try {
    const book = await Book.findById(req.params.id);
    res.json(book);
  } catch (err) {
    res.status(500).send(err.message);
  }
});

// Add new book
app.post('/book', async (req, res) => {
  try {
    const newBook = new Book(req.body);
    const savedBook = await newBook.save();
    res.json(savedBook);
  } catch (err) {
    res.status(500).send(err.message);
  }
});

// Update book
app.put('/book/:id', async (req, res) => {
  try {
    const updatedBook = await Book.findByIdAndUpdate(
      req.params.id,
      { $set: { title: req.body.title } },
      { new: true, upsert: true }
    );
    res.json(updatedBook);
  } catch (err) {
    res.status(500).send(err.message);
  }
});

// Delete book
app.delete('/book/:id', async (req, res) => {
  try {
    const deletedBook = await Book.findByIdAndDelete(req.params.id);
    res.json(deletedBook);
  } catch (err) {
    res.status(500).send(err.message);
  }
});

app.listen(port, () => {
  console.log(`App listening on port ${port}`);
});
Note:
set updates only specified fields, new:true returns the updated document,
and upsert:true creates a new document if none exists.

Final advice
$set → ALWAYS use
new:true → usually yes
upsert:true → think twice

final improved code
===================

js
Copy code
// Get all books
app.get('/book', async (req, res) => {
  try {
    const books = await Book.find({});
    res.setHeader('Cache-Control', 'no-cache, no-store');
    res.json(books); // empty array is OK
  } catch (err) {
    res.status(500).send(err.message);
  }
});

// Get book by ID
app.get('/book/:id', async (req, res) => {
  try {
    const book = await Book.findById(req.params.id);

    if (!book) {
      return res.status(404).json({ message: 'Book not found' });
    }

    res.json(book);
  } catch (err) {
    res.status(500).send(err.message);
  }
});

// Add new book
app.post('/book', async (req, res) => {
  try {
    const newBook = new Book(req.body);
    const savedBook = await newBook.save();
    res.status(201).json(savedBook); // ✅ created
  } catch (err) {
    res.status(500).send(err.message);
  }
});

// Update book (NO UPSERT)
app.put('/book/:id', async (req, res) => {
  try {
    const updatedBook = await Book.findByIdAndUpdate(
      req.params.id,
      { $set: { title: req.body.title } },
      { new: true, upsert: false }
    );

    if (!updatedBook) {
      return res.status(404).json({ message: 'Book not found' });
    }

    res.json(updatedBook);
  } catch (err) {
    res.status(500).send(err.message);
  }
});

// Delete book
app.delete('/book/:id', async (req, res) => {
  try {
    const deletedBook = await Book.findByIdAndDelete(req.params.id);

    if (!deletedBook) {
      return res.status(404).json({ message: 'Book not found' });
    }

    res.json(deletedBook);
  } catch (err) {
    res.status(500).send(err.message);
  }
});

app.listen(port, () => {
  console.log(`App listening on port ${port}`);
});
yaml
Copy code
