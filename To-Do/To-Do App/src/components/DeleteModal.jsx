import { useMutation, useQueryClient } from "@tanstack/react-query";
import { useTasks } from "../utils/ContextApi";
import { deleteTask } from "../utils/service";

export default function DeleteModal() {
  const { currentTask, isDeleteModalOpen, setDeleteModalOpen } = useTasks();

  const queryClient = useQueryClient();
  console.log(currentTask);

  const { mutate: mutateFunc } = useMutation({
    mutationFn: () => deleteTask(currentTask.taskID),
    onSuccess: () => {
      setDeleteModalOpen(false);
      queryClient.invalidateQueries({
        queryKey: ["task"],
      });
    },
  });

  function handleDeleteTask() {
    mutateFunc();
  }

  if (isDeleteModalOpen)
    return (
      <div className="modal__container">
        <div className="modal">
          <p className="delete__text">
            Are you sure about to delete {currentTask.taskName} ?
          </p>
          <div className="modal__footer">
            <button
              className="btn__cancel"
              onClick={() => setDeleteModalOpen(false)}
            >
              Cancel
            </button>
            <button onClick={() => handleDeleteTask()}>Delete</button>
          </div>
        </div>
      </div>
    );
}
