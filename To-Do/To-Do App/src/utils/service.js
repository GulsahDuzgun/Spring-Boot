const BASE_URL = "http://127.0.0.1:4445";

export async function getTasks() {
  const response = await fetch(`${BASE_URL}/task/api/v1/list`);

  if (!response.ok)
    throw new Error("There is an error occured while fetching tasks ");

  const data = await response.json();

  console.log(data);
  return data;
}

export async function createTask(data) {
  if (!data) throw new Error("Data is empty");

  const response = await fetch(`${BASE_URL}/task/api/v1/create`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });

  if (!response.ok)
    throw new Error("There is an error occured while sending created task ");
}

export async function updateTask(id) {
  const response = await fetch(`${BASE_URL}//task/api/v1/update/${id}`);

  if (!response.ok)
    throw new Error("There is an error occured while updating task");
}
