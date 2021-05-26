import React from "react";
import { Form, Container } from "react-bootstrap";

const ImportUsersFromFile = () => {
  return (
    <>
      <Container>
        <Form>
          <Form.Group>
            <Form.File id="uploudFileWithUser" label="Wybierz plik" />
          </Form.Group>
        </Form>
      </Container>
    </>
  );
};

export default ImportUsersFromFile;
