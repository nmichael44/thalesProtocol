package app.model

import cats.data.NonEmptyVector

import java.time.Instant

import smithy4s.{Refinement, RefinementProvider}
import smithy4s.time.Timestamp

given [A]: RefinementProvider[NonEmptyVecSmithy, List[A], NonEmptyVector[A]] =
  Refinement.drivenBy[NonEmptyVecSmithy](
    (list: List[A]) => NonEmptyVector.fromVector(list.toVector).toRight("List cannot be empty"),
    (nev: NonEmptyVector[A]) => nev.toVector.toList,
  )

given RefinementProvider[JavaInstantRefinement, Timestamp, Instant] =
  Refinement.drivenBy[JavaInstantRefinement](
    (t: Timestamp) => Right(Instant.ofEpochSecond(t.epochSecond, t.nano.toLong)),
    (i: Instant) => Timestamp(i.getEpochSecond, i.getNano),
  )
