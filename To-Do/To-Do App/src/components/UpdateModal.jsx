import { useTasks } from "../utils/ContextApi";
import { updateTask } from "../utils/service";
import { useQueryClient } from "@tanstack/react-query";

export default function UpdateModal() {
  const { isUpdateModalOpen, currentTask, setUpdateModalOpen } = useTasks();

  const queryClient = useQueryClient();

  async function handleUpdateTask(e) {
    e.preventDefault();
    const data = Object.fromEntries(
      new FormData(document.querySelector("form.update__form")).entries()
    );

    const resObj = { taskID: currentTask.taskID, ...data };
    console.log(resObj);
    await updateTask(resObj);
    queryClient.invalidateQueries({
      queryKey: ["tasks"],
    });

    setUpdateModalOpen(false);
  }

  if (isUpdateModalOpen)
    return (
      <div className="modal__container">
        <div className="modal">
          <form className="update__form" onSubmit={handleUpdateTask}>
            <div className="input__row">
              <label htmlFor="update__taskName">Task Name</label>
              <input
                name="taskName"
                id="update__taskName"
                type="text"
                defaultValue={currentTask.taskName}
              />
            </div>
            <div className="input__row">
              <label htmlFor="updated__status">Task Status</label>
              <select
                defaultValue={currentTask.statusName}
                name="statusName"
                id="updated__status"
              >
                <option value=""></option>
                <option value="Not Started">Not Started</option>
                <option value="In Progress">In Progress</option>
                <option value="Done">Done</option>
              </select>
            </div>
            <div className="input__row">
              <label htmlFor="updated__task">Task Content </label>
              <textarea
                name="task"
                id="updated__task"
                type="text"
                defaultValue={currentTask.task}
              />
            </div>
            <div className="modal__footer">
              <button
                className="btn__cancel"
                onClick={() => setUpdateModalOpen(false)}
              >
                Cancel
              </button>
              <button type="submit">Update</button>
            </div>
          </form>
        </div>
      </div>
    );
}
