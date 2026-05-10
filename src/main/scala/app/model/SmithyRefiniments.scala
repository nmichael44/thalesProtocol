package app.model

import cats.data.NonEmptyVector

import java.time.Instant

import smithy4s.{Refinement, RefinementProvider}
import smithy4s.time.Timestamp

private val anyVectorRefinement = Refinement.drivenBy[NonEmptyVecSmithy](
  (list: List[Any]) => NonEmptyVector.fromVector(list.toVector).toRight("List cannot be empty"),
  (nev: NonEmptyVector[Any]) => nev.toVector.toList,
)

private type RefinementProvType[A] = RefinementProvider[NonEmptyVecSmithy, List[A], NonEmptyVector[A]]

given [A]: RefinementProvType[A] = anyVectorRefinement.asInstanceOf[RefinementProvType[A]]

given RefinementProvider[JavaInstantRefinement, Timestamp, Instant] =
  Refinement.drivenBy[JavaInstantRefinement](
    (t: Timestamp) => Right(Instant.ofEpochSecond(t.epochSecond, t.nano.toLong)),
    (i: Instant) => Timestamp(i.getEpochSecond, i.getNano),
  )
