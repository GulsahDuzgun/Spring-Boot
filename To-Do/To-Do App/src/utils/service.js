const BASE_URL = "http://127.0.0.1:4445";

export async function getTasks() {
  const response = await fetch(`${BASE_URL}/task/api/v1/list`);

  if (!response.ok)
    throw new Error("There is an error occured while fetching tasks ");

  const data = await response.json();
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

export async function deleteTask(id) {
  const response = await fetch(`${BASE_URL}/task/api/v1/delete/${id}`, {
    method: "DELETE",
  });

  if (!response.ok)
    throw new Error("There is an error occured while deleting task");
}

export async function updateTask(newTaskObj) {
  if (!newTaskObj) throw new Error("The object is empty");

  const { taskID: id } = newTaskObj;
  const response = await fetch(`${BASE_URL}/task/api/v1/update/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(newTaskObj),
  });

  if (!response.ok)
    throw new Error("There is an error occured while updating the task");
}

export async function deleteAllTask() {
  const response = await fetch(`${BASE_URL}/task/api/v1/delete/all`, {
    method: "DELETE",
  });

  if (!response.ok)
    throw new Error("There is an error occured while deleting all task");
}
