CREATE TABLE contacts(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) UNIQUE,
  phone VARCHAR(255),
  category_id INTEGER,
  CONSTRAINT fk_category_contact FOREIGN KEY (category_id) REFERENCES categories(id)
);