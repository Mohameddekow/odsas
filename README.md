# ODSAS


## Contributing guidelines

- Find an issue in the [project board](https://github.com/users/Mohameddekow/projects/7/views/1) and assign it to yourself. You can also create an issue if it doesn't exist.
- Create a branch against main
- Create a PR to main. PullRequests must pass the following checks;
    * Must be approved by a code owner
    * Include all your tests
    * Send pull request once all your inter depending commits are complete
    * Must have every conversation resolved before merging
- We encourage you to use [git rebase](https://www.atlassian.com/git/tutorials/rewriting-history/git-rebase#:~:text=What%20is%20git%20rebase%3F,of%20a%20feature%20branching%20workflow.) for a linear history


## Naming conventions
[we only have 2 modules, `students` and `dean`]
- All Compose navigation Destination components must be suffixed with `Screen` ie. `StudentsScreen`
- All components inside a screen must be suffixed with suffixed with the word `Component` ie. `StudentsComponent`
- All ViewModels must be suffixed with the word `ViewModel` ie. `HomeViewModel`
- All useCases must be prefixed with a get or set depending on functionality and suffixed with Usecase ie. `GetStudentsUsecase`
- All repositories must be suffixed with Repository. ie. `StudentsRepository`
- All repository implementations must be suffixed with `DataRepository` ie. `StudentsDataRepository`
- All public functions in the ViewModel must be prefixed with `on` and suffixed with `action` ie. `onSignInAction()`
- All models should suffix the layer then model. ie. `StudentsDataModel` or `StudentsDomainModel` or `StudentsPresentationModel`
- All mappers should follow the pattern `model-layerFrom-layerTo-mapper` ie. `StudentsDataToDomainMapper`


## Coding Style
### DO
- ViewModel and view will fall under the feature's Ui package
- All Ui components will be under feature's components package
- Include tests if you are making changes to the following;
    - ViewModel
    - Repository
    - Usecase
    - Mappers
- Format your changed files `COMMAND+OPTION+L` for mac users or `CTRL+ALT+L`
- Include a preview for all UI components.

### DON'T
- Don't include the word `impl` in a repository implementation name. Use `DataRepository` instead.

---
>  PRs are :)
