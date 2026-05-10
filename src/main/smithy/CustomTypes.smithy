$version: "2.0"

namespace app.model

use smithy4s.meta#refinement

@trait(selector: "list")
@refinement(
    targetType: "cats.data.NonEmptyVector"
    parameterised: true
    providerImport: "app.model.given"
)
structure nonEmptyVecSmithy {}

@trait(selector: "timestamp")
@refinement(
    targetType: "java.time.Instant",
    providerImport: "app.model.given"
)
structure javaInstantRefinement {}

@javaInstantRefinement
timestamp JavaInstant
